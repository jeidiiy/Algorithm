package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.setGame();
        int playTime = game.playGame();
        System.out.println(playTime);
    }

    static class Game {
        private int playTime = 0;
        private int boardSize;
        private int[][] board;

        // 오른쪽, 아래, 왼쪽, 위
        private int[] dx = {0, 1, 0, -1};
        private int[] dy = {1, 0, -1, 0};
        private int currentDirection = 0; // 기본 - 우측이동

        private Queue<DirectionInfo> directionInfos = new LinkedList<>();
        private LinkedList<Position> snakeBodies = new LinkedList<>();

        public void setGame() throws IOException {
            snakeBodies.offer(Position.of(1, 1)); // 시작 위치는 [1, 1]

            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                boardSize = Integer.parseInt(br.readLine());
                board = new int[boardSize + 1][boardSize + 1];

                // 사과 채우기
                int K = Integer.parseInt(br.readLine());
                for (int i = 0; i < K; i++) {
                    int[] position = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    board[position[0]][position[1]] = 1;
                }

                // 방향 전환 정보 저장
                int L = Integer.parseInt(br.readLine());
                for (int i = 0; i < L; i++) {
                    String[] tokens = br.readLine().split(" ");
                    int X = Integer.parseInt(tokens[0]);
                    char C = tokens[1].charAt(0);

                    DirectionInfo directionInfo = DirectionInfo.of(X, C);
                    directionInfos.offer(directionInfo);
                }
            }
        }

        public int playGame() {
            while (true) {
                playTime++;

                Position head = snakeBodies.peek();
                Position newHead = Position.of(head.getX() + dx[currentDirection],
                        head.getY() + dy[currentDirection]);

                if (isBumpedAgainstBorder(newHead))
                    break;

                if (isTouchedItself(snakeBodies, newHead))
                    break;

                if (isExistApple(board, newHead)) {
                    eatApple(board, newHead);
                } else {
                    moveTail(snakeBodies);
                }

                snakeBodies.offerFirst(newHead);

                if (isItTimeForChangeOfDirection(playTime, directionInfos)) {
                    switch (getNextDirection()) {
                        case 'D':
                            currentDirection = (currentDirection + 1) % 4;
                            break;
                        case 'L':
                            currentDirection = (currentDirection + 3) % 4;
                            break;
                        default:
                            break;
                    }
                }
            }
            return playTime;
        }

        private char getNextDirection() {
            return directionInfos.poll().getDirection();
        }

        private void moveTail(LinkedList<Position> snakeBodies) {
            snakeBodies.pollLast();
        }

        private void eatApple(int[][] board, Position newHead) {
            board[newHead.getX()][newHead.getY()] = 0;
        }

        private boolean isExistApple(int[][] board, Position newHead) {
            return board[newHead.getX()][newHead.getY()] == 1;
        }

        private boolean isItTimeForChangeOfDirection(int playTime,
                Queue<DirectionInfo> directionInfos) {
            return !directionInfos.isEmpty() && directionInfos.peek().getTime() == playTime;
        }

        private boolean isTouchedItself(LinkedList<Position> snakeBodies, Position newHead) {
            return snakeBodies.stream().anyMatch(
                    (body) -> body.getX() == newHead.getX() && body.getY() == newHead.getY());
        }

        private boolean isBumpedAgainstBorder(Position newHead) {
            return newHead.getX() <= 0 || newHead.getY() <= 0 || newHead.getX() > boardSize
                    || newHead.getY() > boardSize;
        }
    }

    final static class Position {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Position of(int x, int y) {
            return new Position(x, y);
        }
    }

    final static class DirectionInfo {
        private int time;
        private char direction;

        public int getTime() {
            return time;
        }

        public char getDirection() {
            return direction;
        }

        private DirectionInfo(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }

        public static DirectionInfo of(int time, char direction) {
            return new DirectionInfo(time, direction);
        }
    }
}
