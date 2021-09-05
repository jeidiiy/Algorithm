package baekjoon.dfs_bfs;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11724 {

  static int[][] graph;
  static boolean[] visited;
  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v] = graph[v][u] = 1;
    }

    int cnt = 0;

    for (int i = 1; i <= N; i++) {
      if (visited[i] == false) {
        dfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }

  static void dfs(int v) {
    if (visited[v] == false) {
      visited[v] = true;
      for (int i = 1; i <= N; i++) {
        if (graph[v][i] == 1) {
          dfs(i);
        }
      }
    } else {
      return;
    }
  }
}
