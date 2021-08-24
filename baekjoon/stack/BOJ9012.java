package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    String input;
    String[] tokens;
    Stack<String> stack = new Stack<>();
    boolean flag = false;

    for (int i = 0; i < T; i++) {
      input = br.readLine();
      tokens = input.split("");
      for (int j = 0; j < tokens.length; j++) {
        if (tokens[j].equals("(")) {
          stack.push(tokens[j]);
          continue;
        }
        if (tokens[j].equals(")")) {
          if (stack.isEmpty()) {
            flag = true;
            break;
          }
          stack.pop();
          continue;
        }
      }
      if (stack.isEmpty()) {
        if(!flag) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else {
        System.out.println("NO");
      }
      stack.clear();
      flag = false;
    }
  }
}
