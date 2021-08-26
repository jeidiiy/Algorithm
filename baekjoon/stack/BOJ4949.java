package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Character> stack = new Stack<>();
    String input;
    char c;
    StringBuilder sb = new StringBuilder();

    while (true) {
      input = br.readLine();

      if (input.equals("."))
        break;

      for (int i = 0; i < input.length(); i++) {
        c = input.charAt(i);

        if (c == '(' || c == '[') {
          stack.push(c);
          continue;
        }
        if (c == ')') {
          if (stack.empty() || stack.peek() != '(') {
            stack.push('n');
            break;
          } else {
            stack.pop();
          }
        }
        if (c == ']') {
          if (stack.empty() || stack.peek() != '[') {
            stack.push('n');
            break;
          } else {
            stack.pop();
          }
        }
      }

      if (stack.size() == 0)
        sb.append("yes").append("\n");
      else
        sb.append("no").append("\n");

      stack.clear();
    }

    System.out.print(sb);
  }
}