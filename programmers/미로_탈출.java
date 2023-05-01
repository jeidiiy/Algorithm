package programmers;

import java.util.*;

public class 미로_탈출 {
    static class Solution {

        static int N, M;
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};
        static char[][] charmaps;

        public int solution(String[] maps) {
            int answer = 0;
            N = maps.length;
            M = maps[0].length();
            Position start = null;

            charmaps = new char[N + 2][M + 2];
            wrapWall();

            for (int i = 1; i <= N; i++) {
                char[] chars = maps[i - 1].toCharArray();
                for (int j = 1; j <= M; j++) {
                    charmaps[i][j] = chars[j - 1];
                    if (chars[j - 1] == 'S')
                        start = new Position(i, j, 0);
                }
            }

            Position lever = bfs(start, 'L');
            if (lever.time == -1)
                return -1;

            Position exit = bfs(lever, 'E');
            if (exit.time == -1)
                return -1;

            answer = exit.time;

            return answer;
        }

        private Position bfs(Position p, char target) {
            boolean[][] isVisited = new boolean[N + 2][M + 2];
            Queue<Position> q = new LinkedList<>();
            q.offer(p);
            isVisited[p.x][p.y] = true;

            while (!q.isEmpty()) {
                Position curP = q.poll();

                if (charmaps[curP.x][curP.y] == target)
                    return curP;

                for (int i = 0; i < 4; i++) {
                    int nx = curP.x + dx[i];
                    int ny = curP.y + dy[i];

                    if (!isVisited[nx][ny] && charmaps[nx][ny] != 'X') {
                        q.offer(new Position(nx, ny, curP.time + 1));
                        isVisited[nx][ny] = true;
                    }
                }
            }

            return new Position(1, 1, -1);
        }

        private static class Position {
            int x;
            int y;
            int time;

            public Position(int x, int y, int time) {
                this.x = x;
                this.y = y;
                this.time = time;
            }
        }

        private void wrapWall() {
            for (int i = 0; i <= N + 1; i++) {
                charmaps[i][0] = 'X';
            }

            for (int i = 0; i <= N + 1; i++) {
                charmaps[i][M + 1] = 'X';
            }

            for (int i = 0; i <= M + 1; i++) {
                charmaps[0][i] = 'X';
            }

            for (int i = 0; i <= M + 1; i++) {
                charmaps[N + 1][i] = 'X';
            }
        }
    }
}
