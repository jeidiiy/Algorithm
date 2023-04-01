package baekjoon.dp;

import java.io.*;

public class BOJ2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        dp[1] = 1L;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.print(dp[n]);
    }
}
