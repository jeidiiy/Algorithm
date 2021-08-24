package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1966 {

  static class Document {
    private int priority;
    private int location;

    public Document(int priority, int location) {
      this.priority = priority;
      this.location = location;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    String input;
    String[] tokens;
    for (int i = 0; i < T; i++) {
      input = br.readLine();
      tokens = input.split(" ");

      int N = Integer.parseInt(tokens[0]);
      int location = Integer.parseInt(tokens[1]);

      Queue<Document> q = new LinkedList<>();
      int cnt = 0;

      tokens = br.readLine().split(" ");

      for (int j = 0; j < N; j++) {
        int priority = Integer.parseInt(tokens[j]);
        q.add(new Document(priority, j));
      }

      while (!q.isEmpty()) {
        boolean flag = false;
        Document J = q.poll();

        for (Document d : q) {
          if (J.priority < d.priority) {
            q.offer(J);
            flag = true;
            break;
          }
        }

        if (!flag) {
          cnt++;
          if (J.location == location) {
            break;
          }
        }
      }

      sb.append(cnt).append("\n");
    }

    System.out.print(sb);
  }
}
