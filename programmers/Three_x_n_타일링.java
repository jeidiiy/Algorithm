package programmers;

public class Three_x_n_타일링 {
    class Solution {
        public int solution(int n) {
            long[] d = new long[n + 1];
            int mod = 1_000_000_007;

            d[0] = 1;
            d[2] = 3;

            for (int i = 4; i <= n; i += 2) {
                d[i] = (d[i - 2] * 4 % mod - d[i - 4] % mod + mod) % mod;
            }

            return (int) d[n];
        }
    }
}
