package dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ1012_BFS {

  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    String line;
    String[] tokens;
    int[][] map;
    boolean[][] visited;
    int tc = 0, n = 0, m = 0, k = 0; // 각각 테스트케이스, 행, 열, 개수

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    tc = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < tc; i++) {
      line = br.readLine().trim();

      tokens = line.split(" ");
      n = Integer.parseInt(tokens[0]);
      m = Integer.parseInt(tokens[1]);
      k = Integer.parseInt(tokens[2]);

      map = new int[n][m];
      visited = new boolean[n][m];

      for (int j = 0; j < k; j++) {
        line = br.readLine().trim();

        tokens = line.split(" ");

        int fromVertex = Integer.parseInt(tokens[0]);
        int toVertex = Integer.parseInt(tokens[1]);

        map[fromVertex][toVertex] = 1;
      }

      int res = bfs(map, visited);
      System.out.println(res);
    }
  }

  public static int bfs(int[][] map, boolean[][] visited) {
    Queue<Node> queue = new LinkedList<>();
    int res = 0;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          visited[i][j] = true;
          queue.offer(new Node(i, j));

          while (!queue.isEmpty()) {
            Node curPos = queue.poll();

            for (int l = 0; l < 4; l++) {
              int nx = curPos.row + dx[l];
              int ny = curPos.col + dy[l];

              if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[i].length) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                  visited[nx][ny] = true;
                  queue.offer(new Node(nx, ny));
                }
              }
            }
          }

          res++;
        }
      }
    }

    return res;
  }

  private static class Node {
    int row, col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}