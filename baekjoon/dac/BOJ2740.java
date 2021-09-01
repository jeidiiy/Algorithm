package baekjoon.dac;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2740 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] matrixA = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        matrixA[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine(), " ");

    st.nextToken();
    int K = Integer.parseInt(st.nextToken());

    int[][] matrixB = new int[M][K];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < K; j++) {
        matrixB[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) {
        int sum = 0;
        for (int k = 0; k < M; k++) {
          sum += matrixA[i][k] * matrixB[k][j];
        }
        sb.append(sum).append(' ');
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }
}