package baekjoon.math;

import java.io.*;

public class BOJ4153 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    String[] tokens;
    int[] tri = new int[3];
    while (true) {
      input = br.readLine();
      tokens = input.split(" ");

      for (int i = 0; i < 3; i++) {
        tri[i] = Integer.parseInt(tokens[i]);
      }

      if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) {
        break;
      }

      if (tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]) {
        System.out.println("right");
      } else if (tri[0] * tri[0] + tri[2] * tri[2] == tri[1] * tri[1]) {
        System.out.println("right");
      } else if (tri[1] * tri[1] + tri[2] * tri[2] == tri[0] * tri[0]) {
        System.out.println("right");
      } else {
        System.out.println("wrong");
      }

    }
  }
}
