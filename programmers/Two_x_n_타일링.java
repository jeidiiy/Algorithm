package programmers;

public class Two_x_n_타일링 {
    class Solution {
        public int solution(int n) {
            int[] d = new int[n + 1];

            d[1] = 1;
            d[2] = 2;

            for (int i = 3; i <= n; i++) {
                d[i] = (d[i - 1] + d[i - 2]) % 1_000_000_007;
            }

            return d[n];
        }
    }
}
