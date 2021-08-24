package baekjoon.math;

import java.io.*;

public class BOJ10250 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    String input;
    String[] tokens;
    int H, W, N;
    H = W = N = 0;
    for (int i = 0; i < T; i++) {
      input = br.readLine();
      tokens = input.split(" ");

      H = Integer.parseInt(tokens[0]);
      W = Integer.parseInt(tokens[1]);
      N = Integer.parseInt(tokens[2]);

      int floor = N % H == 0 ? H : N % H;
      int room = N % H == 0 ? N / H : N / H + 1;

      System.out.println(floor * 100 + room);
    }
  }
}
