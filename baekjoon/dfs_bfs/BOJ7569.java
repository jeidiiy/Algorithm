package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7569 {
  static int[][][] farm3D;
  static int[] dx = { -1, 0, 1, 0, 0, 0 };
  static int[] dy = { 0, 1, 0, -1, 0, 0 };
  static int[] dz = { 0, 0, 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine().trim();
    String[] tokens = input.split(" ");

    int M = Integer.parseInt(tokens[0]);
    int N = Integer.parseInt(tokens[1]);
    int H = Integer.parseInt(tokens[2]);

    farm3D = new int[M][N][H];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        input = br.readLine().trim();
        tokens = input.split(" ");

        for (int k = 0; k < M; k++) {
          farm3D[k][j][i] = Integer.parseInt(tokens[k]);
        }
      }
    }

    System.out.println(bfs(M, N, H));
  }

  public static int bfs(int m, int n, int h) {
    Queue<Tomato> growedTomatosQueue = new LinkedList<>();
    int day = 0;

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (farm3D[k][j][i] == 1)
            growedTomatosQueue.offer(new Tomato(k, j, i, 0));
        }
      }
    }

    while (!growedTomatosQueue.isEmpty()) {
      Tomato curTomato = growedTomatosQueue.poll();
      day = curTomato.day;

      for (int i = 0; i < 6; i++) {
        int nx = curTomato.x + dx[i];
        int ny = curTomato.y + dy[i];
        int nz = curTomato.z + dz[i];

        if (nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h) {
          if (farm3D[nx][ny][nz] == 0) {
            farm3D[nx][ny][nz] = 1;
            growedTomatosQueue.offer(new Tomato(nx, ny, nz, day + 1));
          }
        }
      }
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (farm3D[k][j][i] == 0)
            return -1;
        }
      }
    }

    return day;
  }

  static class Tomato {
    int x, y, z, day;

    public Tomato(int x, int y, int z, int day) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.day = day;
    }
  }
}
