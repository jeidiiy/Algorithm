package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class BOJ2667_DFS {
  private static int n;
  private static int count;
  private static int[][] map;
  private static boolean[][] visited;
  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };
  private static ArrayList<Integer> res;

  public static void main(String[] args) throws IOException {
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    res = new ArrayList<>();

    n = Integer.parseInt(br.readLine().trim());
    map = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      line = br.readLine().trim();

      String[] tokens = line.split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count = 1;
          dfs(i, j);
          res.add(count);
        }
      }
    }

    res.sort((a, b) -> a - b);
    System.out.println(res.size());
    for (int c : res)
      System.out.println(c);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
        if (map[nx][ny] == 1 && !visited[nx][ny]) {
          dfs(nx, ny);
          count++;
        }
      }
    }
  }
}
