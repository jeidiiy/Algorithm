package programmers;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            // 총넓이
            int area = brown + yellow;

            // yellow가 1개 이상 있으려면 가로와 세로는 최소 3 이상이어야 한다.
            // 그러므로 i는 3부터 시작해서 area까지 증가시킨다.
            for (int i = 3; i <= area; i++) {
                // 총넓이를 i로 나누어 다른 변의 길이를 구한다.
                int j = area / i;

                // i가 직사각형의 한 변이 되려면
                // 총넓이를 i로 나누었을 때 나누어 떨어져야 한다.
                // 동시에 j는 3 이상이어야 yellow가 존재할 수 있다.
                if (area % i == 0 && j >= 3) {
                    // 조건에서 가로가 세로와 같거나 크다고 했으므로
                    // col은 큰 값으로, row는 작은 값으로 지정한다.
                    int col = Math.max(i, j);
                    int row = Math.min(i, j);
                    // yellow의 넓이는 (가로 - 2) * (세로 - 2)와 같다.
                    // brown은 테두리이기 때문이다.
                    int centerArea = (col - 2) * (row - 2);

                    // 따라서 centerArea와 yellow가 같으면 답을 구한 것이다.
                    if (centerArea == yellow) {
                        answer[0] = col;
                        answer[1] = row;
                        return answer;
                    }
                }
            }

            return answer;
        }
    }
}
