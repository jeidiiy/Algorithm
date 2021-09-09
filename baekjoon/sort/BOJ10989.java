package baekjoon.sort;

import java.io.*;

public class BOJ10989 {

  static int[] arr = new int[10000001];
  static int[] counting = new int[10000001];
  static int[] result = new int[10000001];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());

    int num;
    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());
      arr[i] = num;
    }

    for (int i = 0; i < N; i++) {
      int idx = arr[i];
      counting[idx]++;
    }

    for (int i = 0; i < counting.length - 1; i++) {
      counting[i + 1] += counting[i];
    }

    for (int i = counting.length - 1; i >= 0; i--) {
      int idxOfCounting = arr[i];
      counting[idxOfCounting]--;
      if (counting[idxOfCounting] >= 0)
        result[counting[idxOfCounting]] = idxOfCounting;
    }

    for (int i = 0; i < result.length; i++) {
      if (result[i] > 0)
        sb.append(result[i]).append('\n');
    }

    System.out.println(sb);
  }
}
