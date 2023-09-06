package programmers;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class 롤케이크_자르기 {
    class Solution {
        public int solution(int[] toppings) {
            int answer = 0;
            Map<Integer, Integer> older = new HashMap<>();
            Set<Integer> younger = new HashSet<>();

            for (int topping : toppings) {
                older.put(topping, older.getOrDefault(topping, 0) + 1);
            }

            for (int topping : toppings) {
                younger.add(topping);
                older.put(topping, older.get(topping) - 1);
                if (older.get(topping) == 0) {
                    older.remove(topping);
                }
                if (older.size() == younger.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
