package dfs_bfs;

import java.util.*;
import java.io.*;

public class BOJ2667_BFS {
  private static int[][] map;
  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    int n;
    String line;
    String[] tokens;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    boolean[][] visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      line = br.readLine();
      tokens = line.split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    ArrayList<Integer> res = new ArrayList<>();

    bfs(visited, res);

    res.sort((a, b) -> a - b);

    bw.write(String.valueOf(res.size()) + "\n");
    for (int c : res) {
      bw.write(String.valueOf(c) + "\n");
    }

    br.close();
    bw.close();
  }

  public static void bfs(boolean[][] visited, ArrayList<Integer> res) {
    int n = visited.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          Queue<Node> queue = new LinkedList<Node>();
          int count = 0;

          visited[i][j] = true;
          queue.offer(new Node(i, j));

          while (!queue.isEmpty()) {
            Node curPos = queue.poll();
            count++;

            for (int k = 0; k < 4; k++) {
              int nx = curPos.row + dx[k];
              int ny = curPos.col + dy[k];

              if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                  visited[nx][ny] = true;
                  queue.offer(new Node(nx, ny));
                }
              }
            }
          }

          res.add(count);
        }
      }
    }
  }

  private static class Node {
    int row, col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
