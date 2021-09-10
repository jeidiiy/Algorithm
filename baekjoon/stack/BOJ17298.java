package baekjoon.stack;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * BOJ 17298 : 오큰수
 *
 * @author kdgyun
 * {@link https://st-lab.tistory.com}
 * {@link https://github.com/kdgyun}
 *
 */

public class BOJ17298 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    Stack<Integer> stack = new Stack<>();

    int N = Integer.parseInt(br.readLine());

    int[] progression = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      progression[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && progression[stack.peek()] < progression[i])
        progression[stack.pop()] = progression[i];

      stack.push(i);
    }

    while (!stack.isEmpty()) {
      progression[stack.pop()] = -1;
    }

    for (int i = 0; i < N; i++) {
      sb.append(progression[i]).append(' ');
    }

    System.out.println(sb);
  }
}