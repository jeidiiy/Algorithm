package programmers;

public class 피로도 {
    class Solution {
        private int max = Integer.MIN_VALUE;
        private boolean[] isVisited;

        public int solution(int k, int[][] dungeons) {
            for (int i = 0; i < dungeons.length; i++) {
                isVisited = new boolean[dungeons.length];
                dfs(dungeons, i, k, 0);
            }

            return max;
        }

        private void dfs(int[][] dungeons, int idx, int fatigue, int count) {
            isVisited[idx] = true;

            if (fatigue < dungeons[idx][0]) {
                max = Math.max(max, count);
                return;
            }

            fatigue -= dungeons[idx][1];
            count += 1;

            if (count == dungeons.length) {
                max = count;
                return;
            }

            for (int i = 0; i < dungeons.length; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(dungeons, i, fatigue, count);
                    isVisited[i] = false;
                }
            }
        }
    }
}
