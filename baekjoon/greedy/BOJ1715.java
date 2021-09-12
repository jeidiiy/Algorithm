package baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BOJ1715 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(0);
      return;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    while (N-- > 0) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    while (pq.size() != 1) {
      int counting = pq.poll() + pq.poll();
      pq.offer(counting);
      list.add(counting);
    }

    int sum = 0;
    for (int element : list) {
      sum += element;
    }

    System.out.println(sum);
  }
}
