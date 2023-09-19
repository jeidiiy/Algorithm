package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스_게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < enemy.length; i++) {
                n -= enemy[i];
                heap.offer(enemy[i]);

                if (n < 0) {
                    if (k > 0) {
                        n += heap.poll();
                        k--;
                    } else {
                        break;
                    }
                }

                answer++;
            }

            return answer;
        }
    }
}
