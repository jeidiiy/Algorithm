package baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    if (N >= K)
      System.out.println(N - K);
    else
      System.out.print(bfs(N, K));
  }

  static int bfs(int src, int dest) {
    Queue<Integer> q = new LinkedList<>();
    int[] board = new int[1000001];

    q.offer(src);
    board[src] = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int i = 0; i < 3; i++) {
        int next;

        if (i == 0) {
          next = cur - 1;
        } else if (i == 1) {
          next = cur + 1;
        } else {
          next = cur * 2;
        }

        if (next == dest) {
          return board[cur];
        }

        if (0 <= next && next <= 100000) {
          if (board[next] == 0) {
            q.offer(next);
            board[next] = board[cur] + 1;
          }
        }
      }
    }

    return 0;
  }
}