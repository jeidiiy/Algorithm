package baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {

  static LinkedList<Integer>[] graph;
  static int[] colors;
  static int RED = 1;
  static int BLUE = -1;
  static boolean isBipartite;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      graph = new LinkedList[V + 1];
      colors = new int[V + 1];
      isBipartite = true;

      for (int j = 1; j <= V; j++) {
        graph[j] = new LinkedList<>();
      }

      for (int j = 1; j <= E; j++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        graph[v1].add(v2);
        graph[v2].add(v1);
      }

      for (int j = 1; j <= V; j++) {
        if (!isBipartite)
          break;

        if (colors[j] == 0) {
          // dfs(j, RED);
          bfs(j, RED);
        }
      }

      if (isBipartite)
        sb.append("YES").append("\n");
      else
        sb.append("NO").append("\n");
    }

    System.out.println(sb);

  }

  static void dfs(int startV, int color) {
    colors[startV] = color;

    for (int adjV : graph[startV]) {
      // 색칠되지 않은 정점이라면
      if (colors[adjV] == 0) {
        dfs(adjV, -color);
      }

      // 인접한 두 노드의 색이 같다면
      if (colors[adjV] == color) {
        isBipartite = false;
        return;
      }
    }
  }

  static void bfs(int startV, int color) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(startV);
    colors[startV] = color;

    while (!q.isEmpty() && isBipartite) {
      int v = q.poll();

      for (int adjV : graph[v]) {
        // 색칠되지 않은 정점이라면
        if (colors[adjV] == 0) {
          q.offer(adjV);
          colors[adjV] = colors[v] * -1;
        }

        // 인접한 두 노드의 색이 같다면
        else if (colors[v] + colors[adjV] != 0) {
          isBipartite = false;
          return;
        }
      }
    }
  }
}
