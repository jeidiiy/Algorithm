package programmers;

public class 푸드_파이트_대회 {
    class Solution {
        public String solution(int[] food) {
            String answer = "0";

            for (int i = food.length - 1; i > 0; i--) {
                int num = food[i];

                for (int j = 0; j < num / 2; j++) {
                    answer = i + answer + i;
                }
            }

            return answer;
        }
    }
}
