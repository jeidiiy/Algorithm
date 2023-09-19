package programmers;

public class N_Queen {
    class Solution {
        private int count;
        private int[] chessboard;

        public int solution(int n) {
            chessboard = new int[n];
            nQueen(0, n);
            return count;
        }

        private void nQueen(int row, int n) {
            if (row == n) {
                count++;
                return;
            }

            for (int i = 0; i < n; i++) {
                chessboard[row] = i;

                if (isPossible(row)) {
                    nQueen(row + 1, n);
                }
            }
        }

        private boolean isPossible(int row) {
            for (int i = 0; i < row; i++) {
                if (chessboard[row] == chessboard[i] || Math.abs(row - i) == Math.abs(chessboard[row] - chessboard[i]))
                    return false;
            }

            return true;
        }
    }
}
