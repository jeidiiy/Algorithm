package baekjoon.dp;

import java.io.*;

public class BOJ1904 {

  static int[] dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    dp = new int[N + 3];
    dp[1] = 1;
    dp[2] = 2;

    if (N == 1)
      System.out.println(1);
    else if (N == 2)
      System.out.println(2);
    else {
      for (int i = 3; i <= N; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
      }
      System.out.println(dp[N]);
    }

    br.close();
  }
}
