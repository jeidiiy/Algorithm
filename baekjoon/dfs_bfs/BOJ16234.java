package baekjoon.dfs_bfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BOJ16234 {

    static int N, L, R;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] land;
    static boolean[][] isVisited;
    static ArrayList<Coordinate> coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        L = Integer.parseInt(split[1]);
        R = Integer.parseInt(split[2]);

        land = new int[N][N];
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.print(move());
    }

    private static int move() {
        int result = 0;
        while (true) {
            boolean isMoved = false;
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        int sum = bfs(i, j);
                        if (coordinates.size() > 1) {
                            changePopulation(sum);
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved)
                return result;
            result++;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Coordinate> q = new LinkedList<>();
        coordinates = new ArrayList<>();

        q.offer(new Coordinate(x, y));
        coordinates.add(new Coordinate(x, y));
        isVisited[x][y] = true;

        int sum = land[x][y];
        while (!q.isEmpty()) {
            Coordinate c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = c.x + dx[i];
                int nextY = c.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;

                if (isVisited[nextX][nextY])
                    continue;

                int diff = Math.abs(land[c.x][c.y] - land[nextX][nextY]);

                if (L <= diff && diff <= R) {
                    q.offer(new Coordinate(nextX, nextY));
                    coordinates.add(new Coordinate(nextX, nextY));
                    sum += land[nextX][nextY];
                    isVisited[nextX][nextY] = true;
                }
            }
        }

        return sum;
    }

    private static void changePopulation(int sum) {
        int avg = sum / coordinates.size();
        for (Coordinate c : coordinates) {
            land[c.x][c.y] = avg;
        }
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
