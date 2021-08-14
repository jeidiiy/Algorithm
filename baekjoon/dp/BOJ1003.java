package dp;

import java.io.*;

public class BOJ1003 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(br.readLine());
    int[][] dp = new int[41][2];

    dp[0][0] = 1;
    dp[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      dp[i][0] = dp[i - 1][1];
      dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }

    int N;
    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
    }

    bw.write(sb.toString());

    br.close();
    bw.close();
  }
}
