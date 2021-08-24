package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ2178 {
  static int n, m;
  static int[][] maze;
  static boolean[][] visited;

  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    String line;
    String[] tokens;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    line = br.readLine().trim();
    tokens = line.split(" ");

    n = Integer.parseInt(tokens[0]);
    m = Integer.parseInt(tokens[1]);

    maze = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      line = br.readLine().trim();
      tokens = line.split("");

      for (int j = 0; j < m; j++) {
        maze[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    System.out.println(bfs(0, 0));

    br.close();
  }

  public static int bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<Node>();

    queue.offer(new Node(x, y));

    while (!queue.isEmpty()) {
      Node curPos = queue.poll();
      x = curPos.row;
      y = curPos.col;

      for (int k = 0; k < 4; k++) {
        int nx = curPos.row + dx[k];
        int ny = curPos.col + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (maze[nx][ny] == 1) {
            maze[nx][ny] = maze[x][y] + 1;
            queue.offer(new Node(nx, ny));
          }
        }
      }
    }

    return maze[n - 1][m - 1];
  }

  private static class Node {
    int row, col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
