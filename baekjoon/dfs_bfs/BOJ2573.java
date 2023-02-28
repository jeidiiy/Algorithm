package baekjoon.dfs_bfs;

import java.io.*;
import java.util.Arrays;
public class BOJ2573 {

    static int N, M;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");

            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            map = new int[N][M];

            boolean[][] isVisited;

            for (int i = 0; i < N; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line[j];
                }
            }

            int ans = 0;
            Loop1: while (true) {
                isVisited = new boolean[N][M];
                boolean flag = false;
                boolean allMelt = true;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] > 0 && !isVisited[i][j]) {
                            if (flag)
                                break Loop1;
                            else
                                flag = true;
                            allMelt = false;
                            dfs(i, j, isVisited);
                        }
                    }
                }
                if (allMelt) {
                    System.out.println(0);
                    return;
                }
                ans++;
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y, boolean[][] isVisited) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if (map[nextX][nextY] > 0 && !isVisited[nextX][nextY])
                dfs(nextX, nextY, isVisited);
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if (map[nextX][nextY] == 0 && !isVisited[nextX][nextY])
                map[x][y]--;
        }

        if (map[x][y] < 0)
            map[x][y] = 0;
    }
}
