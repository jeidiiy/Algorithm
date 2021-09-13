package baekjoon.greedy;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1744 {

  static PriorityQueue<Integer> positivePQ = new PriorityQueue<>((a, b) -> b - a);
  static PriorityQueue<Integer> negativePQ = new PriorityQueue<>((a, b) -> a - b);

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(br.readLine());
      return;
    }

    while (N-- > 0) {
      int num = Integer.parseInt(br.readLine());

      if (num > 0) {
        positivePQ.offer(num);
      } else {
        negativePQ.offer(num);
      }
    }

    long sum = 0L;
    while (positivePQ.size() >= 2) {
      int a = positivePQ.poll();
      int b = positivePQ.poll();
      // 나중에 뽑는 쪽이 무조건 작은 수이므로 b만 검사하면 된다.
      if (b == 1)
        sum += a + b;
      else
        sum += a * b;
    }

    while (negativePQ.size() >= 2) {
      // 0일 경우 음수와 곱하면 0이 되므로 검사할 필요가 없다.
      sum += negativePQ.poll() * negativePQ.poll();
    }

    if (!positivePQ.isEmpty()) {
      sum += positivePQ.poll();
    }

    if (!negativePQ.isEmpty()) {
      sum += negativePQ.poll();
    }

    if (sum >= Math.pow(2, 31)) {
      System.out.println(Math.pow(2, 31) - 1);
      return;
    }

    System.out.println(sum);
  }
}
