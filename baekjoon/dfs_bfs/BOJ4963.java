package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4963 {
    static int[][] map;
    // 상하좌우, 오른쪽윗대각, 오른쪽아랫대각, 왼쪽윗대각, 왼쪽아랫대각
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static boolean[][] isVisited;
    static int width;
    static int height;
    static int answer;
    static final int LAND = 1;
    static final int SEA = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] tokens = br.readLine().split(" ");
                width = Integer.parseInt(tokens[0]);
                height = Integer.parseInt(tokens[1]);
                answer = 0;

                if (width == 0 && height == 0)
                    break;

                map = new int[height + 1][width + 1];
                isVisited = new boolean[height + 1][width + 1];

                for (int h = 0; h < height; h++) {
                    int[] inputs = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

                    for (int w = 0; w < width; w++) {
                        map[h][w] = inputs[w];
                    }
                }

                for (int h = 0; h < height; h++) {
                    for (int w = 0; w < width; w++) {
                        if (map[h][w] == LAND && !isVisited[h][w]) {
                            dfs(h, w);
                            answer++;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }

    }

    private static int dfs(int h, int w) {
        isVisited[h][w] = true;
        int currentLocation = map[h][w];

        for (int i = 0; i < 8; i++) {
            int nextH = h + dx[i];
            int nextW = w + dy[i];

            if (nextH < 0 || nextW < 0 || nextH > height || nextW > width) {
                continue;
            }

            if (!isVisited[nextH][nextW] && map[nextH][nextW] == LAND) {
                dfs(nextH, nextW);
            }
        }
    }
}
