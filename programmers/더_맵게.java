package programmers;

import java.util.PriorityQueue;

public class 더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int elem : scoville) {
                heap.add(elem);
            }

            int count = 0;
            while (heap.size() > 1 && heap.peek() < K) {
                int newScoville = heap.poll() + heap.poll() * 2;
                heap.add(newScoville);
                count++;
            }

            if (heap.size() == 1 && heap.peek() < K) {
                count = -1;
            }

            return count;
        }
    }
}
