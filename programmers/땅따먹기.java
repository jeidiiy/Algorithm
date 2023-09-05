package programmers;

public class 땅따먹기 {
    class Solution {
        public int solution(int[][] land) {
            int answer = 0;
            int[][] dp = new int[land.length][land[0].length];

            for (int col = 0; col < land[0].length; col++) {
                dp[0][col] = land[0][col];
            }

            for (int row = 1; row < land.length; row++) {
                for (int col = 0; col < land[0].length; col++) {
                    for (int prevCol = 0; prevCol < land[0].length; prevCol++) {
                        if (col != prevCol) {
                            dp[row][col] = Math.max(dp[row][col], dp[row - 1][prevCol] + land[row][col]);
                        }
                    }
                }
            }

            for (int col = 0; col < 4; col++) {
                answer = Math.max(answer, dp[land.length - 1][col]);
            }

            return answer;
        }
    }
}
