package programmers.greedy;

import java.util.*;

public class 요격_시스템 {
    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            // e 기준으로 오름차순 정렬
            Arrays.sort(targets, (o1, o2) -> {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            });

            int end = targets[0][1];
            answer++;

            for (int[] t : targets) {
                if (t[0] >= end) {
                    end = t[1];
                    answer++;
                }
            }

            return answer;
        }
    }
}
