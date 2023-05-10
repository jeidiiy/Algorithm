package baekjoon.dp;

import java.io.*;
import java.util.Arrays;

public class BOJ11053 {

    static int[] A;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new Integer[N];

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Top-Down
        // for (int i = 0; i < N; i++) {
        //     LIS(i);
        // }

        // Bottom-Up
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = dp[0];

        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (A[i] < A[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
