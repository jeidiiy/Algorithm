package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {

  static int N;
  static int M;
  static int[] arr;
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];

    progression(0);
    System.out.println(sb);
  }

  static void progression(int depth) {
    if (depth == M) {
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1])
          return;
      }
      for (int val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      arr[depth] = i;
      progression(depth + 1);
    }
  }
}
