package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class 게임_맵_최단거리 {
    class Solution {
        private int targetX;
        private int targetY;
        private final int[] dx = { -1, 1, 0, 0 };
        private final int[] dy = { 0, 0, -1, 1 };

        public int solution(int[][] maps) {
            targetX = maps.length;
            targetY = maps[0].length;

            int[][] borderedMaps = bordering(maps);

            return bfs(borderedMaps);
        }

        private int bfs(int[][] maps) {
            Queue<Position> q = new LinkedList<>();
            q.offer(new Position(1, 1, 1));

            while (!q.isEmpty()) {
                Position p = q.poll();

                if (p.x == targetX && p.y == targetY) {
                    return p.distance;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (maps[nx][ny] == 1) {
                        // 재방문 회피를 위해 0으로 변경
                        maps[nx][ny] = 0;
                        q.offer(new Position(nx, ny, p.distance + 1));
                    }
                }
            }

            return -1;
        }

        static class Position {
            public int x;
            public int y;
            public int distance;

            public Position(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }

        // 맵을 0으로 감싸서 배열 초과 오류에 대한 메인 로직 간소화
        private int[][] bordering(int[][] maps) {
            int[][] result = new int[maps.length + 2][maps[0].length + 2];

            for (int i = 1; i <= maps.length; i++) {
                for (int j = 1; j <= maps[0].length; j++) {
                    result[i][j] = maps[i - 1][j - 1];
                }
            }

            return result;
        }
    }
}
