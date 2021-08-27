package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866 {

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    String input;
    StringTokenizer st;
    Deque deque = new Deque();

    for (int i = 0; i < N; i++) {
      input = br.readLine();
      st = new StringTokenizer(input, " ");

      String instruction = st.nextToken();

      if (instruction.equals("push_front")) {
        deque.push_front(Integer.parseInt(st.nextToken()));
        continue;
      }
      if (instruction.equals("push_back")) {
        deque.push_back(Integer.parseInt(st.nextToken()));
        continue;
      }
      if (instruction.equals("pop_front")) {
        int res = deque.pop_front();
        sb.append(res).append("\n");
        continue;
      }
      if (instruction.equals("pop_back")) {
        int res = deque.pop_back();
        sb.append(res).append("\n");
        continue;
      }
      if (instruction.equals("size")) {
        int res = deque.size();
        sb.append(res).append("\n");
        continue;
      }
      if (instruction.equals("empty")) {
        int res = deque.empty();
        sb.append(res).append("\n");
        continue;
      }
      if (instruction.equals("front")) {
        int res = deque.front();
        sb.append(res).append("\n");
        continue;
      }
      if(instruction.equals("back")) {
        int res = deque.back();
        sb.append(res).append("\n");
        continue;
      }
    }

    System.out.print(sb);
  }

  static class Deque {

    public LinkedList<Integer> deque;

    public Deque() {
      deque = new LinkedList<>();
    }

    public void push_front(int x) {
      deque.offerFirst(x);
    }

    public void push_back(int x) {
      deque.offerLast(x);
    }

    public int pop_front() {
      return !deque.isEmpty() ? deque.pollFirst() : -1;
    }

    public int pop_back() {
      return !deque.isEmpty() ? deque.pollLast() : -1;
    }

    public int size() {
      return deque.size();
    }

    public int empty() {
      return deque.isEmpty() ? 1 : 0;
    }

    public int front() {
      return !deque.isEmpty() ? deque.peekFirst() : -1;
    }

    public int back() {
      return !deque.isEmpty() ? deque.peekLast() : -1;
    }
  }
}
