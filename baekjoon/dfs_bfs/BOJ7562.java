package baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {

  static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
  static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
  static int I;
  static int destX, destY;
  static int[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int i = 0; i < T; i++) {

      I = Integer.parseInt(br.readLine());

      board = new int[I][I];
      visited = new boolean[I][I];

      st = new StringTokenizer(br.readLine());
      int srcX = Integer.parseInt(st.nextToken());
      int srcY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      destX = Integer.parseInt(st.nextToken());
      destY = Integer.parseInt(st.nextToken());

      bfs(srcX, srcY);

      sb.append(board[destX][destY]).append("\n");
    }

    System.out.print(sb);
  }

  static void bfs(int srcX, int srcY) {
    Queue<Pos> q = new LinkedList<Pos>();

    q.offer(new Pos(srcX, srcY));
    visited[srcX][srcY] = true;

    while (!q.isEmpty()) {
      Pos curPos = q.poll();
      int curX = curPos.getX();
      int curY = curPos.getY();

      if (curX == destX && curY == destY)
        return;

      for (int i = 0; i < 8; i++) {
        int nx = curX + dx[i];
        int ny = curY + dy[i];

        if (isGetOut(nx, ny) && !visited[nx][ny]) {
          q.offer(new Pos(nx, ny));
          visited[nx][ny] = true;
          board[nx][ny] = board[curX][curY] + 1;
        }
      }
    }
  }

  static boolean isGetOut(int x, int y) {
    return x >= 0 && y >= 0 && x < I && y < I;
  }

  static class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }

}
