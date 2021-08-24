package baekjoon.string;

import java.io.*;

class BOJ11721 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = br.readLine();

    int start = 0;
    int end = 10;
    int len = line.length() / end + 1;

    for (int i = 1; i <= len; i++, start = end, end = 10 * i) {
      if (i == len) { // 마지막 줄인 경우
        bw.write(line.substring(start, start + line.length() % 10));
        break;
      }
      bw.write(line.substring(start, end) + "\n");
    }

    br.close();
    bw.close();
  }
}