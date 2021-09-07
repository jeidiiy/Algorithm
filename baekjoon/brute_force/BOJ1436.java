package baekjoon.brute_force;

import java.io.*;

public class BOJ1436 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int numOfEnd = 666;
    int cnt = 1;

    while (cnt != N) {
      numOfEnd++;
      if (String.valueOf(numOfEnd).contains("666")) {
        cnt++;
      }
    }

    System.out.println(numOfEnd);
  }
}
