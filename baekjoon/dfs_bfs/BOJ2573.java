package baekjoon.dfs_bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2573 {

    static int N, M;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");

            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line[j];
                }
            }

            int ans = 0, cnt = 0;
            while ((cnt = calcDividedBerg()) < 2) {
                if (cnt == 0) {
                    ans = 0;
                    break;
                }
                bfs();
                ans++;
            }

            System.out.println(ans);
        }
    }

    private static int calcDividedBerg() {
        boolean[][] isVisited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    dfs(i, j, isVisited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int x, int y, boolean[][] isVisited) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if (map[nextX][nextY] > 0 && !isVisited[nextX][nextY])
                dfs(nextX, nextY, isVisited);
        }
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();

        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.add(new Pos(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pos pos = queue.remove();

            int seaCnt = 0;

            for (int i = 0; i < 4; i++) {
                int adjX = pos.getX() + dx[i];
                int adjY = pos.getY() + dy[i];

                if (adjX < 0 || adjY < 0 || adjX >= N || adjY >= M)
                    continue;

                if (!isVisited[adjX][adjY] && map[adjX][adjY] <= 0)
                    seaCnt++;
            }

            if (map[pos.getX()][pos.getY()] - seaCnt < 0)
                map[pos.getX()][pos.getY()] = 0;
            else
                map[pos.getX()][pos.getY()] -= seaCnt;
        }
    }

    static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
