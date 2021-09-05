package baekjoon.string;

import java.io.*;

public class BOJ1032 {

  static String[] files;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    files = new String[N];

    for (int i = 0; i < N; i++) {
      files[i] = br.readLine();
    }

    int len = files[0].length();
    int[] diff = new int[len];

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < N - 1; j++) {
        if (files[j].charAt(i) != files[j + 1].charAt(i)) {
          diff[i] = 1;
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len; i++) {
      if (diff[i] == 0) {
        sb.append(files[0].charAt(i));
      } else {
        sb.append("?");
      }
    }

    System.out.println(sb);
  }
}
