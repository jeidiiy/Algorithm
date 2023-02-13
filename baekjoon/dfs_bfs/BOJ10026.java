package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
    static int normal = 0;
    static int abnormal = 0;
    static int N;
    static char[][] pictureForNoamrl;
    static char[][] pictureForAbnormal;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            pictureForNoamrl = new char[N + 1][N + 1];
            pictureForAbnormal = new char[N + 1][N + 1];
            isVisited = new boolean[N + 1][N + 1];

            for (int x = 0; x < N; x++) {
                char[] pixels = br.readLine().toCharArray();
                for (int y = 0; y < N; y++) {
                    pictureForNoamrl[x][y] = pixels[y];
                    pictureForAbnormal[x][y] = pixels[y] == 'G' ? 'R' : pixels[y];
                }
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!isVisited[x][y]) {
                        dfs(x, y, pictureForNoamrl);
                        normal++;
                    }
                }
            }

            isVisited = new boolean[N + 1][N + 1]; // 방문 기록 초기화

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!isVisited[x][y]) {
                        dfs(x, y, pictureForAbnormal);
                        abnormal++;
                    }
                }
            }

            System.out.print(normal + " " + abnormal);
        }
    }

    private static void dfs(int x, int y, char[][] picture) {
        isVisited[x][y] = true;
        char currentPixel = picture[x][y];

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX > N || nextY > N)
                continue;

            if (!isVisited[nextX][nextY] && picture[nextX][nextY] == currentPixel)
                dfs(nextX, nextY, picture);
        }
    }
}
