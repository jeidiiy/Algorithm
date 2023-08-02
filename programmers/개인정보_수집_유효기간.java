package programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class 개인정보_수집_유효기간 {
    class Solution {

        private static final int DAY_OF_MONTH = 28;

        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> termsMap = new HashMap<>();
            int todayDay = getDay(today);

            for (String term : terms) {
                String[] termDetails = term.split(" ");
                String kindOfTerm = termDetails[0];
                Integer period = Integer.valueOf(termDetails[1]);

                termsMap.put(kindOfTerm, period);
            }

            int index = 0;
            for (String privacy : privacies) {
                index++;
                String[] privacyDetails = privacy.split(" ");
                String collectDate = privacyDetails[0];
                String kindOfTerm = privacyDetails[1];
                int expireDay = getDay(collectDate) + (termsMap.get(kindOfTerm) * DAY_OF_MONTH);

                if (expireDay <= todayDay) {
                    answer.add(index);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private int getDay(String date) {
            String[] dateDetails = date.split("\\.");
            int year = Integer.parseInt(dateDetails[0]);
            int month = Integer.parseInt(dateDetails[1]);
            int day = Integer.parseInt(dateDetails[2]);
            return (year * 12 * DAY_OF_MONTH) + (month * DAY_OF_MONTH) + day;
        }
    }
}
