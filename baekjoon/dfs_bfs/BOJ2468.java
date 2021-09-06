package baekjoon.dfs_bfs;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2468 {

  /**
   * 강수량이 주어지지 않기 때문에 주어진 건물의 최저 높이부터 건물의 최대 높이까지
   * 경우의 수를 모두 탐색한 뒤에 안전한 영역이 가장 많을 때의 최대 개수를 출력해야 한다.
   * 이때문에 문제 유형에 브루트포스가 포함되어 있는 것 같다.
   */

  static int[][] area;
  static boolean[][] isSinked;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int cnt, N;
  static int max = 1; // 비가 오지 않은 경우엔 전체가 안전 구역이다.

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    area = new int[N][N];
    Set<Integer> heights = new TreeSet<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int h = Integer.parseInt(st.nextToken());
        heights.add(h);
        area[i][j] = h;
      }
    }

    // 모든 높이에 대하여 최대값을 구한다.
    heights.stream().filter(h -> h <= 100).forEach(fh -> findResult(fh));

    System.out.println(max);
  }

  static void findResult(int h) {
    isSinked = new boolean[N][N];
    int safeArea = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] > h && !isSinked[i][j]) {
          dfs(i, j, h);
          safeArea++;
        }
      }
    }
    max = Math.max(max, safeArea);
  }

  static void dfs(int x, int y, int h) {
    if (isSinked[x][y] || area[x][y] <= h)
      return;

    isSinked[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= N || ny < 0 || ny >= N)
        continue;

      dfs(nx, ny, h);
    }
  }
}
