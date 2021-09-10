package baekjoon.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ5430 {

  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      Deque<Integer> deque = new LinkedList<>();
      String p = br.readLine();

      int len = Integer.parseInt(br.readLine());

      Pattern pattern = Pattern.compile("[0-9]+");
      Matcher matcher = pattern.matcher(br.readLine());

      while (matcher.find()) {
        deque.offer(Integer.parseInt(matcher.group()));
      }

      AC(p, deque);
    }

    System.out.println(sb);
  }

  static void AC(String p, Deque<Integer> deque) {
    boolean isRight = true;

    for (int j = 0; j < p.length(); j++) {
      if (p.charAt(j) == 'R') {
        isRight = !isRight;
        continue;
      }

      if (p.charAt(j) == 'D') {
        if (isRight) {
          if (deque.pollFirst() == null) {
            sb.append("error").append('\n');
            return;
          }
        } else {
          if (deque.pollLast() == null) {
            sb.append("error").append('\n');
            return;
          }
        }
      }
    }

    print(deque, isRight);
  }

  static void print(Deque<Integer> deque, boolean isRight) {
    sb.append('[');

    if (deque.size() > 0) {
      if (isRight) {
        sb.append(deque.pollFirst());

        while (!deque.isEmpty()) {
          sb.append(',').append(deque.pollFirst());
        }
      } else {
        sb.append(deque.pollLast());

        while (!deque.isEmpty()) {
          sb.append(',').append(deque.pollLast());
        }
      }
    }

    sb.append(']').append('\n');
  }
}
