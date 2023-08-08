package programmers;

public class 예상_대진표 {
    class Solution {
        public int solution(int n, int a, int b) {
            int depth = (int) (Math.log(n) / Math.log(2));
            int small = Math.min(a, b);
            int large = Math.max(a, b);

            while (true) {
                n /= 2;
                if (small <= n && n < large)
                    break;
                if (small > n)
                    small -= n;
                if (large > n)
                    large -= n;
                depth--;
            }

            return depth;
        }
    }
}
