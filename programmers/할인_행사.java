package programmers;

import java.util.HashMap;

public class 할인_행사 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            for (int day = 0; day < discount.length - 9; day++) {
                HashMap<String, Integer> map = init(want, number);
                for (int i = day; i < day + 10; i++) {
                    if (map.containsKey(discount[i])) {
                        map.put(discount[i], map.get(discount[i]) - 1);
                        continue;
                    }

                    break;
                }

                boolean canAllBuy = true;
                for (int value : map.values()) {
                    if (value > 0) {
                        canAllBuy = false;
                        break;
                    }
                }

                if (canAllBuy) {
                    answer++;
                }
            }

            return answer;
        }

        private HashMap<String, Integer> init(String[] want, int[] number) {
            HashMap<String, Integer> result = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                result.put(want[i], number[i]);
            }
            return result;
        }
    }
}
