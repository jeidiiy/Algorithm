package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ14503 {

    static int N, M;
    static int ans;
    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int startX = Integer.parseInt(split[0]);
        int startY = Integer.parseInt(split[1]);
        int startDirection = Integer.parseInt(split[2]);

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] roomDetail =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                room[i][j] = roomDetail[j];
            }
        }

        operateRobot(startX, startY, startDirection);

        System.out.println(ans);
    }

    private static void operateRobot(int x, int y, int direction) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x, y, direction));

        while (!q.isEmpty()) {
            Coordinate c = q.poll();

            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (room[c.x][c.y] == 0) {
                room[c.x][c.y] = 2;
                ans++;
            }

            // 2. 현재 칸의 주변 4칸 확인
            boolean existNotClean = false;
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + dx[i];
                int nextY = c.y + dy[i];

                if (room[nextX][nextY] == 0) {
                    existNotClean = true;
                    break;
                }
            }

            if (existNotClean) {
                int curDir = c.d;
                for (int i = 3; i >= 0; i--) {
                    int nextDir = (curDir + i) % 4;
                    int nextX = c.x + dx[nextDir];
                    int nextY = c.y + dy[nextDir];
                    if (room[nextX][nextY] == 0) {
                        q.offer(new Coordinate(nextX, nextY, nextDir));
                        break;
                    }
                }
            } else {
                int curDir = c.d;

                int nextX = c.x - dx[curDir];
                int nextY = c.y - dy[curDir];

                if (room[nextX][nextY] == 1)
                    break;

                q.offer(new Coordinate(nextX, nextY, curDir));
            }
        }
    }

    static class Coordinate {
        int x;
        int y;
        int d;

        public Coordinate(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
