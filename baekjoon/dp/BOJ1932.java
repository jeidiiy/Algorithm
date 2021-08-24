package baekjoon.dp;

import java.io.*;

public class BOJ1932 {

  static int[][] nums;
  static Integer[][] dp;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    nums = new int[n][n];
    dp = new Integer[n][n];

    String input;
    String[] tokens;
    for (int i = 0; i < n; i++) {
      input = br.readLine();
      tokens = input.split(" ");

      for (int j = 0; j < i + 1; j++) {
        nums[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      dp[n - 1][i] = nums[n - 1][i];
    }

    System.out.println(solution(0, 0));

  }

  static int solution(int depth, int idx) {
    if (depth == n - 1)
      return dp[depth][idx];

    if (dp[depth][idx] == null) {
      dp[depth][idx] = Math.max(solution(depth + 1, idx), solution(depth + 1, idx + 1)) + nums[depth][idx];
    }

    return dp[depth][idx];
  }
}
