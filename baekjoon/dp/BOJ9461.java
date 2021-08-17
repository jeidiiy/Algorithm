package dp;

import java.io.*;

public class BOJ9461 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long[] dp;
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());

      dp = new long[N + 6];

      dp[1] = 1L;
      dp[2] = 1L;
      dp[3] = 1L;
      dp[4] = 2L;
      dp[5] = 2L;

      for (int j = 6; j <= N; j++) {
        dp[j] = dp[j - 5] + dp[j - 1];
      }

      System.out.println(dp[N]);
    }
  }
}
