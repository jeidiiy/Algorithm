package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1987 {
    static int R;
    static int C;
    static int MAX = Integer.MIN_VALUE;
    static int[][] board;
    static boolean[] isDuplicated = new boolean[26];
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = br.readLine().split(" ");
            R = Integer.parseInt(tokens[0]);
            C = Integer.parseInt(tokens[1]);

            board = new int[R][C];

            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for (int j = 0; j < C; j++) {
                    board[i][j] = input.charAt(j) - 'A';
                }
            }

            dfs(0, 0, 0);

            System.out.println(MAX);
        }
    }

    private static void dfs(int r, int c, int count) {
        if (isDuplicated[board[r][c]]) {
            MAX = Math.max(MAX, count);
            return;
        } else {
            isDuplicated[board[r][c]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = r + dx[i];
                int nextY = c + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C)
                    dfs(nextX, nextY, count + 1);
            }

            isDuplicated[board[r][c]] = false;
        }
    }
}
