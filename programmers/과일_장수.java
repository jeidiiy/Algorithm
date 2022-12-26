package programmers;

import java.util.*;

public class 과일_장수 {
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            // 이익이 발생하지 않는 경우
            if (score.length < m)
                return 0;

            Arrays.sort(score);

            // score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder())
            // .mapToInt(Integer::intValue).toArray();

            for (int i = score.length; i >= m; i -= m) {
                answer += score[i - m] * m;
            }

            return answer;
        }
    }

}
