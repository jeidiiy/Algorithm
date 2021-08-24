package baekjoon.dp;

import java.io.*;
import static java.lang.Math.*;

public class BOJ1149 {

  final static int RED = 0;
  final static int GREEN = 1;
  final static int BLUE = 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] tokens;

    int[][] cost = new int[N][3];

    for (int i = 0; i < N; i++) {
      tokens = br.readLine().split(" ");

      cost[i][RED] = Integer.parseInt(tokens[0]);
      cost[i][GREEN] = Integer.parseInt(tokens[1]);
      cost[i][BLUE] = Integer.parseInt(tokens[2]);
    }

    for (int i = 1; i < N; i++) {
      cost[i][RED] += min(cost[i - 1][GREEN], cost[i - 1][BLUE]);
      cost[i][GREEN] += min(cost[i - 1][RED], cost[i - 1][BLUE]);
      cost[i][BLUE] += min(cost[i - 1][RED], cost[i - 1][GREEN]);
    }

    System.out.println(min(min(cost[N - 1][RED], cost[N - 1][GREEN]), cost[N - 1][BLUE]));

    br.close();
  }
}
