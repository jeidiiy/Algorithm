package programmers;

public class 행렬_테두리_회전하기 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int[][] matrix = new int[rows][columns];

            init(matrix);

            for (int attempt = 0; attempt < queries.length; attempt++) {
                int[] query = queries[attempt];

                int startX = query[0] - 1;
                int startY = query[1] - 1;
                int endX = query[2] - 1;
                int endY = query[3] - 1;

                int min = matrix[startX][startY];
                int prev = matrix[startX][startY];
                int tmp = 0;
                for (int col = startY; col < endY; col++) {
                    tmp = matrix[startX][col + 1];
                    matrix[startX][col + 1] = prev;
                    prev = tmp;
                    min = Math.min(min, prev);
                }

                for (int row = startX; row < endX; row++) {
                    tmp = matrix[row + 1][endY];
                    matrix[row + 1][endY] = prev;
                    prev = tmp;
                    min = Math.min(min, prev);
                }

                for (int col = endY; col > startY; col--) {
                    tmp = matrix[endX][col - 1];
                    matrix[endX][col - 1] = prev;
                    prev = tmp;
                    min = Math.min(min, prev);
                }

                for (int row = endX; row > startX; row--) {
                    tmp = matrix[row - 1][startY];
                    matrix[row - 1][startY] = prev;
                    prev = tmp;
                    min = Math.min(min, prev);
                }

                answer[attempt] = min;
            }

            return answer;
        }

        private void init(int[][] matrix) {
            int num = 1;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = num++;
                }
            }
        }
    }
}