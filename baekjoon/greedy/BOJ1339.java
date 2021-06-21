package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

class BOJ1339 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine().trim());
    String[] lines = new String[num];
    int[] alpha = new int[26];

    for (int i = 0; i < num; i++) {
      lines[i] = br.readLine().trim();
    }

    for (int i = 0; i < num; i++) {
      int temp = (int) Math.pow(10, lines[i].length() - 1);
      for (int j = 0; j < lines[i].length(); j++) {
        alpha[(int) lines[i].charAt(j) - 65] += temp;
        temp /= 10;
      }
    }

    Arrays.sort(alpha);
    int index = 9;
    int sum = 0;

    for (int i = alpha.length - 1; i >= 0; i--) {
      if (alpha[i] == 0) {
        break;
      }
      sum += alpha[i] * index;
      index--;
    }

    bw.write(String.valueOf(sum));
    bw.flush();

    br.close();
    bw.close();
  }
}