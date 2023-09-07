package programmers;

import java.util.Set;
import java.util.HashSet;

public class 연속_부분_수열_합의_개수 {
    class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();

            for (int i = 1; i <= elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    int sum = 0;
                    for (int k = j; k < j + i; k++) {
                        sum += elements[k % elements.length];
                    }
                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}