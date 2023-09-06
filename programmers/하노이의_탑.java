package programmers;

import java.util.List;
import java.util.ArrayList;

public class 하노이의_탑 {

    class Solution {
        private List<int[]> list = new ArrayList<>();

        public int[][] solution(int n) {
            hanoi(n, 1, 2, 3);

            int[][] answer = new int[list.size()][2];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }

        private void hanoi(int n, int from, int by, int to) {
            if (n == 1) {
                list.add(new int[] { from, to });
                return;
            }

            hanoi(n - 1, from, to, by);
            list.add(new int[] { from, to });
            hanoi(n - 1, by, from, to);
        }
    }
}
