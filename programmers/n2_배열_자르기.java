package programmers;

public class n2_배열_자르기 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] result = new int[(int) (right - left) + 1];

            for (int i = 0; left <= right; i++, left++) {
                int col = (int) (left / n + 1);
                int row = (int) (left % n + 1);
                result[i] = Math.max(col, row);
            }

            return result;
        }
    }
}
