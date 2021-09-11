package baekjoon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583 {

  static boolean[][] isPainted;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int M, N, K;
  static int cnt;
  static StringBuffer sb = new StringBuffer();
  static ArrayList<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    isPainted = new boolean[M][N];

    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int i = y1; i < y2; i++) {
        for (int j = x1; j < x2; j++) {
          isPainted[i][j] = true;
        }
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        bfs(i, j);
      }
    }

    Collections.sort(list);
    list.stream().forEach(e -> sb.append(e).append(' '));

    System.out.println(cnt);
    System.out.println(sb);
  }

  static void bfs(int x, int y) {

    if (isPainted[x][y] == true)
      return;

    Queue<Point> q = new LinkedList<Point>();

    q.offer(new Point(x, y));
    isPainted[x][y] = true;

    int area = 0;
    while (!q.isEmpty()) {
      area++;
      Point curPoint = q.poll();

      int curX = curPoint.getX();
      int curY = curPoint.getY();

      for (int i = 0; i < 4; i++) {
        int nx = curX + dx[i];
        int ny = curY + dy[i];

        // 칸을 벗어나면
        if (nx < 0 || nx >= M || ny < 0 || ny >= N)
          continue;

        // 이미 칠해져 있다면
        if (isPainted[nx][ny] == true)
          continue;

        // 주위에 칠해지지 않은 공간이 있다면
        q.offer(new Point(nx, ny));
        isPainted[nx][ny] = true;

      }
    }

    cnt++;
    list.add(area);
  }

  static class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
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