package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class 두_큐_합_같게_만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            Queue<Long> q1 = new LinkedList<>();
            Queue<Long> q2 = new LinkedList<>();

            int attempt = 0;
            int limit = queue1.length + queue2.length;
            long q1Total = 0L;
            long q2Total = 0L;

            for (int elem : queue1) {
                q1.offer(Long.valueOf(elem));
                q1Total += elem;
            }

            for (int elem : queue2) {
                q2.offer(Long.valueOf(elem));
                q2Total += elem;
            }

            if ((q1Total + q2Total) % 2 == 1) {
                return -1;
            }

            while (q1Total != q2Total) {
                if (attempt >= limit) {
                    return -1;
                }

                while (q1Total > q2Total) {
                    long elem = q1.poll();
                    q2.offer(elem);
                    q1Total -= elem;
                    q2Total += elem;
                    attempt += 1;
                }

                while (q2Total > q1Total) {
                    long elem = q2.poll();
                    q1.offer(elem);
                    q2Total -= elem;
                    q1Total += elem;
                    attempt += 1;
                }
            }

            return attempt;
        }
    }
}
