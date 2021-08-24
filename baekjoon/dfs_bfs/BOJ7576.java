package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ7576 {
  static int[][] farm;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine().trim();
    String[] tokens = input.split(" ");

    int n = Integer.parseInt(tokens[0]);
    int m = Integer.parseInt(tokens[1]);

    farm = new int[m][n];

    for (int i = 0; i < m; i++) {
      tokens = br.readLine().trim().split(" ");

      for (int j = 0; j < n; j++) {
        farm[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    System.out.println(bfs(n, m));
  }

  public static int bfs(int n, int m) {
    Queue<Tomato> growedTomatosQueue = new LinkedList<>();
    int day = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (farm[i][j] == 1)
          growedTomatosQueue.offer(new Tomato(i, j, 0));
      }
    }

    while (!growedTomatosQueue.isEmpty()) {
      Tomato curPos = growedTomatosQueue.poll();
      day = curPos.day;

      for (int i = 0; i < 4; i++) {
        int nx = curPos.x + dx[i];
        int ny = curPos.y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (farm[ny][nx] == 0) {
            farm[ny][nx] = 1;
            growedTomatosQueue.offer(new Tomato(ny, nx, day + 1));
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (farm[i][j] == 0)
          return -1;
      }
    }

    return day;
  }

  private static class Tomato {
    int y, x, day;

    public Tomato(int y, int x, int day) {
      this.y = y;
      this.x = x;
      this.day = day;
    }
  }
}
