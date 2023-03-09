package baekjoon.dfs_bfs;

import java.io.*;
import java.util.Arrays;

public class BOJ1926 {

    static int n, m, paintCnt, max;
    static int[][] paint;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");

            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            paint = new int[n][m];
            isVisited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < m; j++) {
                    paint[i][j] = nums[j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!isVisited[i][j] && paint[i][j] == 1) {
                        dfs(i, j, 1);
                        paintCnt++;
                    }
                }
            }

            System.out.print(paintCnt + "\n" + max);
        }
    }

    private static int dfs(int i, int j, int area) {
        isVisited[i][j] = true;

        if (paint[i][j] == 0) {
            return area;
        }

        for (int x = 0; x < 4; x++) {
            int nextX = i + dx[x];
            int nextY = j + dy[x];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                continue;

            if (!isVisited[nextX][nextY] && paint[nextX][nextY] == 1)
                area = dfs(nextX, nextY, area + 1);
        }

        if (max < area)
            max = area;

        return area;
    }
}
