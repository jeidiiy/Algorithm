package dp;

import java.io.*;

public class BOJ9184 {

  static int[][][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    String[] tokens;
    int[] nums = new int[3];
    dp = new int[21][21][21];
    StringBuffer sb = new StringBuffer();

    while (true) {
      input = br.readLine();
      tokens = input.split(" ");

      for (int i = 0; i < 3; i++) {
        nums[i] = Integer.parseInt(tokens[i]);
      }

      if (nums[0] == -1 && nums[1] == -1 && nums[2] == -1)
        break;

      sb.append("w(")
        .append(nums[0])
        .append(", ")
        .append(nums[1])
        .append(", ")
        .append(nums[2])
        .append(") = ")
        .append(w(nums[0], nums[1], nums[2]))
        .append("\n");
    }

    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  static int w(int a, int b, int c) {

    if (check(a, b, c) && dp[a][b][c] != 0)
      return dp[a][b][c];

    if (a <= 0 || b <= 0 || c <= 0)
      return 1;

    if (a > 20 || b > 20 || c > 20)
      return dp[20][20][20] = w(20, 20, 20);

    if (a < b && b < c)
      return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

    return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
  }

  static boolean check(int a, int b, int c) {
    return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
  }
}
