package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ1874 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    int m = 0;

    while (n-- > 0) {

      int value = Integer.parseInt(br.readLine());

      if (value > m) {
        for (int i = m + 1; i <= value; i++) {
          stack.push(i);
          sb.append("+").append("\n");
        }
        m = value;
      } else if (stack.peek() != value) {
        System.out.println("NO");
        return;
      }

      stack.pop();
      sb.append("-").append("\n");
    }

    System.out.println(sb);
  }
}
