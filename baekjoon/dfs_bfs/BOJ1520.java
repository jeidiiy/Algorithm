package baekjoon.dfs_bfs;

import java.io.*;

public class BOJ1520 {

    static int M;
    static int N;
    static int[][] map;
    static int[][] dp;
    static final int[] dx = {0, 1, 0, -1}; // 우하좌상
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = br.readLine().split(" ");

            M = Integer.parseInt(tokens[0]);
            N = Integer.parseInt(tokens[1]);

            map = new int[M][N];
            dp = new int[M][N];

            for (int i = 0; i < M; i++) {
                tokens = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    dp[i][j] = -1;

            System.out.println(dfs(0, 0));
        }
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                if (map[x][y] > map[nextX][nextY]) {
                    dp[x][y] += dfs(nextX, nextY);
                }
            }
        }

        return dp[x][y];
    }
}
