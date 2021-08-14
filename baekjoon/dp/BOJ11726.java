package dp;

import java.io.*;

public class BOJ11726 {

  static int[] dp = new int[1001];

  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int res = tiling(N);

    bw.write(String.valueOf(res));

    br.close();
    bw.close();
  }

  private static int tiling(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (dp[n] != 0)
      return dp[n];

    return dp[n] = (tiling(n - 1) + tiling(n - 2)) % 10007;
  }
}
