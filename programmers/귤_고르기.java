package programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 귤_고르기 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int elem : tangerine) {
                if (!map.containsKey(elem)) {
                    map.put(elem, 1);
                    continue;
                }

                map.put(elem, map.get(elem) + 1);
            }

            List<Integer> theNumber = new ArrayList<>(map.values());

            Collections.sort(theNumber, Collections.reverseOrder());

            int answer = 0;
            for (int number : theNumber) {
                k -= number;
                answer++;
                if (k <= 0)
                    break;
            }

            return answer;
        }
    }
}
