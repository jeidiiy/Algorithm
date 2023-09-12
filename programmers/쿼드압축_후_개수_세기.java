package programmers;

public class 쿼드압축_후_개수_세기 {
    class Solution {
        private int zeros = 0;
        private int ones = 0;

        public int[] solution(int[][] arr) {
            int[] answer = new int[2];
            int N = arr.length;

            zip(arr, 0, 0, N);

            answer[0] = zeros;
            answer[1] = ones;

            return answer;
        }

        private boolean check(int[][] arr, int n, int m, int size, int val) {
            for (int i = n; i < n + size; i++) {
                for (int j = m; j < m + size; j++) {
                    if (arr[i][j] != val) {
                        return false;
                    }
                }
            }

            return true;
        }

        private void zip(int[][] arr, int n, int m, int size) {
            if (check(arr, n, m, size, arr[n][m])) {
                if (arr[n][m] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                return;
            }

            zip(arr, n, m, size / 2);
            zip(arr, n, m + size / 2, size / 2);
            zip(arr, n + size / 2, m, size / 2);
            zip(arr, n + size / 2, m + size / 2, size / 2);
        }
    }
}
