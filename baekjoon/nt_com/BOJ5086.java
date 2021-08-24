package baekjoon.nt_com;

import java.io.*;

public class BOJ5086 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    String[] tokens;
    int N, M;

    while (true) {
      input = br.readLine();
      tokens = input.split(" ");
      N = Integer.parseInt(tokens[0]);
      M = Integer.parseInt(tokens[1]);

      if (N == 0 && M == 0)
        break;

      if (M % N == 0) {
        System.out.println("factor");
        continue;
      } else if (N % M == 0) {
        System.out.println("multiple");
      } else {
        System.out.println("neither");
      }
    }

    br.close();
  }
}
