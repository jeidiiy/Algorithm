package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ14502 {

    static int N;
    static int M;
    static int ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] tmp;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int SPACE = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final Queue<Position> virusQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");

            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            map = new int[N][M];
            tmp = new int[N][M];

            createMap(br);
            solution();

            System.out.println(ans);
        }
    }

    private static void createMap(BufferedReader br) throws IOException {
        for (int x = 0; x < N; x++) {
            int[] line =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int y = 0; y < M; y++) {
                map[x][y] = line[y];
            }
        }
    }

    private static void solution() {
        simulate();
    }

    private static void simulate() {
        buildWall(0);
    }

    private static void buildWall(int count) {
        if (count == 3) {
            processMainLogic(); // 처참한 네이밍 수준..
            return;
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == SPACE) {
                    map[x][y] = WALL;
                    buildWall(count + 1);
                    map[x][y] = SPACE;
                }
            }
        }
    }

    private static void processMainLogic() {
        copyMapToTmp();
        findSourceOfVirus();
        spreadVirus();
        calcMax();
    }

    private static void copyMapToTmp() {
        for (int x = 0; x < N; x++)
            for (int y = 0; y < M; y++)
                tmp[x][y] = map[x][y];
    }

    private static void findSourceOfVirus() {
        virusQueue.clear();

        for (int x = 0; x < N; x++)
            for (int y = 0; y < M; y++)
                if (tmp[x][y] == VIRUS)
                    virusQueue.offer(Position.of(x, y));
    }

    private static void spreadVirus() {
        while (!virusQueue.isEmpty()) {
            Position position = virusQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = position.getX() + dx[i];
                int nextY = position.getY() + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if (tmp[nextX][nextY] == SPACE) {
                    tmp[nextX][nextY] = VIRUS;
                    virusQueue.offer(Position.of(nextX, nextY));
                }
            }
        }
    }

    private static void calcMax() {
        ans = Math.max(ans, countSafeArea());
    }

    private static int countSafeArea() {
        int count = 0;
        for (int x = 0; x < N; x++)
            for (int y = 0; y < M; y++)
                if (tmp[x][y] == SPACE)
                    count++;

        return count;
    }


    private static class Position {
        private int x;
        private int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public static Position of(int x, int y) {
            return new Position(x, y);
        }
    }
}
