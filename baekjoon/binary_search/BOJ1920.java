package baekjoon.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

  static long[] arr;
  static long[] candidates;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    arr = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    candidates = new long[M];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      candidates[i] = Long.parseLong(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      long target = candidates[i];
      sb.append(binary_search(target, 0, arr.length - 1)).append('\n');
    }

    System.out.print(sb);
  }

  static int binary_search(long target, int start, int end) {
    int mid;

    while (start <= end) {
      mid = (start + end) / 2;
      if (arr[mid] == target) {
        return 1;
      } else if (arr[mid] > target) {
        end = mid - 1;
      } else if (arr[mid] < target) {
        start = mid + 1;
      }
    }
    return 0;
  }
}
