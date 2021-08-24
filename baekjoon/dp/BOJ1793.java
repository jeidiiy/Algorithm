package baekjoon.dp;

import java.io.*;
import java.math.BigInteger;

public class BOJ1793 {

  static BigInteger dp[];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;

    dp = new BigInteger[251];

    dp[0] = new BigInteger("1");
    dp[1] = new BigInteger("1");
    dp[2] = new BigInteger("3");

    for (int i = 3; i <= 250; i++) {
      dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
    }

    while ((input = br.readLine()) != null) {
      int N = Integer.parseInt(input);
      bw.write(dp[N] + "\n");
    }

    br.close();
    bw.close();
  }
}
