package programmers;

public class 연속된_부분_수열의_합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int len = sequence.length;
            int left = 0, right = len; // 정답을 담는 변수
            int L = 0, R = 0; // 포인터 변수
            int sum = 0;

            while (L < len) {
                while (R < len && sum < k) {
                    sum += sequence[R++];
                }

                if (sum == k) {
                    int range = (R - 1) - L;
                    if ((right - left) > range) {
                        left = L;
                        right = R - 1;
                    }
                }

                sum -= sequence[L++];
            }

            return new int[] { left, right };
        }
    }
}