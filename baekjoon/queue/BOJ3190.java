package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int playTime = 0;
            // 오른쪽, 아래, 왼쪽, 위
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int currentDirection = 0; // 기본 - 우측이동
            Queue<DirectionInfo> directionInfos = new LinkedList<>();
            LinkedList<Position> snakeBodies = new LinkedList<>();
            snakeBodies.offer(Position.of(1, 1)); // 시작 위치는 [1, 1]

            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N + 1][N + 1];

            // 사과 채우기
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
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

            // 게임 시작
            while (true) {

                playTime++;

                // 한 칸 전진
                Position head = snakeBodies.peek();
                Position newHead = Position.of(head.getX() + dx[currentDirection],
                        head.getY() + dy[currentDirection]);

                // 벽에 닿았으면 종료
                if (newHead.getX() <= 0 || newHead.getY() <= 0 || newHead.getX() > N
                        || newHead.getY() > N)
                    break;

                // 자기 몸에 닿으면 종료
                boolean isTouched = snakeBodies.stream().anyMatch(
                        (body) -> body.getX() == newHead.getX() && body.getY() == newHead.getY());
                if (isTouched)
                    break;

                // 사과 확인. 있으면 사과 지우고 통과, 없으면 꼬리 제거
                if (board[newHead.getX()][newHead.getY()] == 1) {
                    board[newHead.getX()][newHead.getY()] = 0;
                } else {
                    snakeBodies.pollLast();
                }

                snakeBodies.offerFirst(newHead);

                // 방향 전환 확인
                if (!directionInfos.isEmpty() && directionInfos.peek().getTime() == playTime) {
                    switch (directionInfos.peek().getDirection()) {
                        case 'D':
                            currentDirection = (currentDirection + 1) % 4;
                            break;
                        case 'L':
                            currentDirection = (currentDirection + 3) % 4;
                            break;
                        default:
                            break;
                    }
                    directionInfos.poll();
                }
            }

            System.out.println(playTime);
        }
    }

    final static class Position {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Position of(int x, int y) {
            return new Position(x, y);
        }
    }

    static enum Direction {
        UP(0), DOWN(1), LEFT(2), RIGHT(3);

        private final int order;

        Direction(int order) {
            this.order = order;
        }

        int getOrder() {
            return order;
        }
    }

    final static class DirectionInfo {
        private int time;
        private char direction;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public char getDirection() {
            return direction;
        }

        public void setDirection(char direction) {
            this.direction = direction;
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
