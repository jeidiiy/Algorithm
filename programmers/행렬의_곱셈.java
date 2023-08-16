package programmers;

public class 행렬의_곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int lenOfRow = arr1.length;
            int lenOfCol = arr2[0].length;
            int lenOfK = arr1[0].length; // 앞 행렬의 열 = 뒷 행렬의 행

            int[][] answer = new int[lenOfRow][lenOfCol];

            for (int row = 0; row < lenOfRow; row++) {
                for (int col = 0; col < lenOfCol; col++) {
                    for (int k = 0; k < lenOfK; k++) {
                        answer[row][col] += arr1[row][k] * arr2[k][col];
                    }
                }
            }

            return answer;
        }
    }
}
