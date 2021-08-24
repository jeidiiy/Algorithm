package baekjoon.nt_com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1929 {

  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    check = new boolean[N + 1];

    solution(M, N);

    for (int i = M; i <= N; i++) {
      if (!check[i])
        sb.append(i).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  static void solution(int M, int N) {
    check[0] = check[1] = true;

    for (int i = 2; i <= Math.sqrt(check.length); i++) {
      if (check[i])
        continue;

      for (int j = i * i; j < check.length; j += i) {
        check[j] = true;
      }
    }
  }
}
