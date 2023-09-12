package programmers;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class 무인도_여행 {

    class Solution {
        private final List<Integer> answerList = new ArrayList<>();
        private final int[] dx = { -1, 1, 0, 0 };
        private final int[] dy = { 0, 0, -1, 1 };
        private boolean[][] visit;

        public int[] solution(String[] maps) {
            // 범위 초과 처리를 간단히 하기 위해 +2를 하여 0으로 감쌈
            int[][] nMaps = new int[maps.length + 2][maps[0].length() + 2];
            visit = new boolean[maps.length + 2][maps[0].length() + 2];

            for (int i = 1; i <= maps.length; i++) {
                String[] tokens = maps[i - 1].split("");
                for (int j = 1; j <= maps[0].length(); j++) {
                    String token = tokens[j - 1];
                    nMaps[i][j] = token.equals("X") ? 0 : Integer.parseInt(token);
                }
            }

            for (int i = 1; i <= maps.length; i++) {
                for (int j = 1; j <= maps[0].length(); j++) {
                    if (!visit[i][j] && nMaps[i][j] != 0) {
                        bfs(nMaps, i, j);
                    }
                }
            }

            if (answerList.isEmpty()) {
                return new int[] { -1 };
            }

            Collections.sort(answerList);

            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        private void bfs(int[][] maps, int x, int y) {
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(x, y));
            visit[x][y] = true;

            int result = 0;
            while (!q.isEmpty()) {
                Point p = q.poll();
                result += maps[p.x][p.y];

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (!visit[nx][ny] && maps[nx][ny] != 0) {
                        // 방문 처리는 큐에 넣기 전에
                        visit[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }

            if (result != 0) {
                answerList.add(result);
            }
        }

        static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
