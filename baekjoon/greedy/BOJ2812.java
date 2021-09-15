package baekjoon.greedy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    Stack<Integer> stack = new Stack<>();

    int[] arr;
    int count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    arr = new int[N];

    String target = br.readLine();

    for (int i = 0; i < target.length(); i++) {
      arr[i] = target.charAt(i) - '0';
    }

    for (int i = 0; i < arr.length; i++) {
      while (count < K && !stack.isEmpty() && stack.peek() < arr[i]) {
        stack.pop();
        count++;
      }
      stack.push(arr[i]);
    }

    for (int i = 0; i < N - K; i++) {
      sb.append(stack.elementAt(i));
    }

    System.out.println(sb);
  }
}
