package baekjoon.greedy;

import java.io.*;

public class BOJ1080 {

    static int N, M;
    static int[][] srcMatrix;
    static int[][] dstMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        srcMatrix = new int[N][M];
        dstMatrix = new int[N][M];

        // src
        for (int i = 0; i < N; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                srcMatrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        // dst
        for (int i = 0; i < N; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                dstMatrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        int answer = convert();

        System.out.println(answer);
    }

    private static int convert() {
        int answer = 0;

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (srcMatrix[i][j] != dstMatrix[i][j]) {
                    toggleNumber(i, j);
                    answer++;
                }
            }
        }

        boolean isSame = checkSame();

        return isSame ? answer : -1;
    }

    private static void toggleNumber(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                srcMatrix[i][j] = srcMatrix[i][j] ^ 1;
            }
        }
    }

    private static boolean checkSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (srcMatrix[i][j] != dstMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
