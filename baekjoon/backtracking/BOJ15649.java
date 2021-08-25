package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {

  static int N;
  static int M;
  static int[] arr;
  static boolean[] visited;
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N];
    arr = new int[M];

    progression(0);
    System.out.println(sb);
  }

  static void progression(int depth) {
    if (depth == M) {
      for (int val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i] == false) {
        visited[i] = true;
        arr[depth] = i + 1;
        progression(depth + 1);

        visited[i] = false;
      }
    }
  }
}
