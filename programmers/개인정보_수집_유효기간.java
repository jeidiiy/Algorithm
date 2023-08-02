package programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class 개인정보_수집_유효기간 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> termsMap = new HashMap<>();

            for (String term : terms) {
                String[] termDetails = term.split(" ");

                termsMap.put(termDetails[0], Integer.valueOf(termDetails[1]));
            }

            int index = 0;
            for (String privacy : privacies) {
                index++;
                String[] privacyDetails = privacy.split(" ");
                String collectDate = privacyDetails[0];

                String[] dateDetails = collectDate.split("\\.");
                int year = Integer.valueOf(dateDetails[0]);
                int month = Integer.valueOf(dateDetails[1]);
                int day = Integer.valueOf(dateDetails[2]);

                String kindOfTerm = privacyDetails[1];

                int validTerm = termsMap.get(kindOfTerm);

                month += validTerm;

                if (month >= 13) {
                    if (month % 12 == 0) {
                        year = year + (month / 12) - 1;
                        month = 12;
                    } else {
                        year = year + (month / 12);
                        month = month - 12 * (month / 12);
                    }
                }

                String[] todayDetails = today.split("\\.");
                int todayYear = Integer.valueOf(todayDetails[0]);
                int todayMonth = Integer.valueOf(todayDetails[1]);
                int todayDay = Integer.valueOf(todayDetails[2]);

                if (todayYear < year) {
                    continue;
                } else if (todayYear == year) {
                    if (todayMonth < month) {
                        continue;
                    } else if (todayMonth == month) {
                        if (todayDay < day) {
                            continue;
                        }
                    }
                }

                answer.add(index);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
