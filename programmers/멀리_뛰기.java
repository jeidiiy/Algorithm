package programmers;

public class 멀리_뛰기 {
    class Solution {
        public long solution(int n) {
            long[] dp = new long[n + 1];

            if (n == 1)
                return 1;

            dp[1] = 1L;
            dp[2] = 2L;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            return dp[n];
        }
    }
}
