package programmers;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class 신고_결과_받기 {

    class Solution {
        public Integer[] solution(String[] id_list, String[] reports, int k) {
            HashMap<String, HashSet<String>> reportMap = new LinkedHashMap<>();
            HashMap<String, Integer> reportedMap = new HashMap<>();
            HashMap<String, Boolean> banUserMap = new LinkedHashMap<>();
            HashMap<String, Integer> answerMap = new LinkedHashMap<>();

            for (String id : id_list) {
                reportMap.put(id, new HashSet<>());
                reportedMap.put(id, 0);
                banUserMap.put(id, false);
                answerMap.put(id, 0);
            }

            for (String report : reports) {
                // 0 - 신고자, 1 - 피신고자
                String[] token = report.split(" ");
                reportMap.get(token[0]).add(token[1]);
            }

            for (HashSet<String> reportedUserSet : reportMap.values()) {
                for (String reportedUser : reportedUserSet) {
                    reportedMap.put(reportedUser, reportedMap.get(reportedUser) + 1);

                    if (reportedMap.get(reportedUser) >= k) {
                        banUserMap.put(reportedUser, true);
                    }
                }
            }

            banUserMap.forEach((user, isBan) -> {
                if (isBan) {
                    for (String key : reportMap.keySet()) {
                        if (reportMap.get(key).contains(user)) {
                            answerMap.put(key, answerMap.get(key) + 1);
                        }
                    }
                }
            });

            return (Integer[]) answerMap.values().toArray(new Integer[answerMap.size()]);
        }
    }
}
