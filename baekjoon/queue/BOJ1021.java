package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    LinkedList<Integer> deque = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    int count = 0;

    for (int i = 1; i <= N; i++) {
      deque.offer(i);
    }

    input = br.readLine();
    st = new StringTokenizer(input);

    for (int i = 0; i < M; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    while (!list.isEmpty()) {
      int target = list.poll();
      int targetIdx = deque.indexOf(target);

      if (targetIdx > deque.size() / 2) {
        while (deque.peekFirst() != target) {
          deque.offerFirst(deque.pollLast());
          count++;
        }
      } else {
        while (deque.peekFirst() != target) {
          deque.offerLast(deque.pollFirst());
          count++;
        }
      }
      deque.pollFirst();
    }

    System.out.print(count);
  }
}
