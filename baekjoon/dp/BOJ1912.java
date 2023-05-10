package baekjoon.dp;

import java.io.*;
import java.util.Arrays;

public class BOJ1912 {

    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        topDown(n - 1);
        // bottomUp();

        System.out.print(max);
    }

    private static void topDown(int n) {
        dp = new Integer[arr.length];
        dp[0] = arr[0];
        max = arr[0];

        recur(n);
    }

    private static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }

    private static void bottomUp() {
        dp = new Integer[arr.length];
        dp[0] = arr[0];
        max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
    }
}
