package baekjoon.dp;

import java.io.*;

public class BOJ2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N ==  1) {
			System.out.print(1);
			return;
		}

		int[] dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.print(dp[N]);
	}
}