package baekjoon.backtracking;

import java.io.*;

public class BOJ14889 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] table;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            table = new int[N][N];
            isVisited = new boolean[N];

            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(split[j]);
                }
            }

            organize(0, 0);
            System.out.print(min);
        }
    }

    private static void organize(int idx, int cnt) {
        if (cnt == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                organize(i + 1, cnt + 1);
                isVisited[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] == true && isVisited[j] == true) {
                    team_start += table[i][j];
                    team_start += table[j][i];
                }

                else if (isVisited[i] == false && isVisited[j] == false) {
                    team_link += table[i][j];
                    team_link += table[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.print(val);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}