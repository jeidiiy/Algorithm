package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ2206 {

  static int N, M;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int[][] map;
  static int[][] visited;
  static int destroy;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] tokens = br.readLine().split(" ");

    N = Integer.parseInt(tokens[0]);
    M = Integer.parseInt(tokens[1]);

    map = new int[N][M];
    visited = new int[N][M];

    for (int i = 0; i < N; i++) {
      tokens = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
        visited[i][j] = Integer.MAX_VALUE;
      }
    }

    int res = bfs(0, 0);
    System.out.println(res);
  }

  static int bfs(int x, int y) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(x, y, 1, 0));
    visited[x][y] = 0; // 처음 공사 횟수

    while (!q.isEmpty()) {
      Point curPoint = q.poll();
      int curX = curPoint.getX();
      int curY = curPoint.getY();

      if (curX == N - 1 && curY == M - 1) {
        return curPoint.getDistance();
      }

      for (int i = 0; i < 4; i++) {
        int nx = curX + dx[i];
        int ny = curY + dy[i];

        // 범위 밖으로 벗어나는 경우
        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
          continue;

        if (visited[nx][ny] > curPoint.getDestroy()) {
          if (map[nx][ny] == 0) { // 벽이 아닌 경우
            q.offer(new Point(nx, ny, curPoint.getDistance() + 1, curPoint.getDestroy()));
            visited[nx][ny] = curPoint.getDestroy();
          } else { // 벽인 경우
            if (curPoint.getDestroy() == 0) { // 벽을 부수지 않았다면
              q.offer(new Point(nx, ny, curPoint.getDistance() + 1, curPoint.getDestroy() + 1));
              visited[nx][ny] = curPoint.getDestroy() + 1;
            }
          }
        }
      }
    }

    return -1;
  }

  static class Point {
    private int x;
    private int y;
    private int distance;
    private int destroy;

    public Point(int x, int y, int distance, int destroy) {
      this.x = x;
      this.y = y;
      this.distance = distance;
      this.destroy = destroy;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public int getDistance() {
      return distance;
    }

    public int getDestroy() {
      return destroy;
    }
  }
}
