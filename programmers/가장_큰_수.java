package programmers;

import java.util.Arrays;

public class 가장_큰_수 {
    class Solution {
        public String solution(int[] numbers) {
            String[] strnums = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                strnums[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(strnums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

            if (strnums[0].equals("0")) {
                return "0";
            }

            String answer = "";
            for (int i = 0; i < strnums.length; i++) {
                answer += strnums[i];
            }

            return answer;
        }
    }
}