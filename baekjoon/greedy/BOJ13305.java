package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13305 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[] distances = new long[N - 1];
    long[] costOfGas = new long[N];
    long fullCost = 0;

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, " ");

    for (int i = 0; st.hasMoreTokens(); i++) {
      distances[i] = Long.parseLong(st.nextToken());
    }

    input = br.readLine();
    st = new StringTokenizer(input, " ");

    for (int i = 0; st.hasMoreTokens(); i++) {
      costOfGas[i] = Long.parseLong(st.nextToken());
    }

    int cur = 0;
    for (int i = 0; i < N - 1; i++) {
      fullCost += costOfGas[cur] * distances[i];
      if (costOfGas[cur] > costOfGas[i + 1]) {
        cur = i + 1;
      }
    }

    System.out.println(fullCost);
  }
}