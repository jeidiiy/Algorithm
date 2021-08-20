package math;

import java.io.*;

public class BOJ2581 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    boolean flag = false;
    int sum, min, count;
    sum = min = count = 0;

    for (int i = M; i <= N; i++) {
      count = 0;

      if (i == 2) {
        sum += i;
        min = i;
        flag = true;
      }

      if (i % 2 == 0)
        continue;

      for (int j = 3; j <= i; j += 2) {
        if (i % j == 0)
          count++;
      }

      if (count == 1) {
        sum += i;
        if (!flag) {
          min = i;
          flag = true;
        }
      }
    }

    if (sum == 0) {
      System.out.print(-1);
      return;
    }

    sb.append(sum).append("\n");
    sb.append(min);

    System.out.print(sb);

  }
}
