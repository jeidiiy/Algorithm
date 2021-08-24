package baekjoon.math;

import java.io.*;

public class BOJ11653 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int n = 2;

    while (true) {
      if (N % n == 0) {
        sb.append(n).append("\n");
        N /= n;
        continue;
      }

      if (N == 1) {
        break;
      }

      n++;
    }

    System.out.print(sb);

  }
}
