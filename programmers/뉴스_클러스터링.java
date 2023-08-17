package programmers;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class 뉴스_클러스터링 {
    class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            Map<String, Integer> set1 = createMultiSet(str1);
            Map<String, Integer> set2 = createMultiSet(str2);

            int unionSize = getUnionSize(set1, set2);
            int intersectionSize = getIntersectionSize(set1, set2);

            double jaccardSimilarity = getJaccardSimilarity(unionSize, intersectionSize);
            int answer = (int) Math.floor(jaccardSimilarity * 65536);

            return answer;
        }

        private double getJaccardSimilarity(int unionSize, int intersectionSize) {
            if (unionSize == 0 && intersectionSize == 0) {
                return 1;
            }

            return (double) intersectionSize / unionSize;
        }

        private int getIntersectionSize(Map<String, Integer> set1, Map<String, Integer> set2) {
            int result = 0;

            Set<String> intersection = new HashSet<>(set1.keySet());
            intersection.retainAll(set2.keySet());

            for (String key : intersection) {
                result += Math.min(set1.get(key), set2.get(key));
            }

            return result;
        }

        private int getUnionSize(Map<String, Integer> set1, Map<String, Integer> set2) {
            int result = 0;

            Set<String> union = new HashSet<>(set1.keySet());
            union.addAll(set2.keySet());

            for (String key : union) {
                if (set1.containsKey(key) && set2.containsKey(key)) {
                    result += Math.max(set1.get(key), set2.get(key));
                    continue;
                }

                if (set1.containsKey(key)) {
                    result += set1.get(key);
                    continue;
                }

                if (set2.containsKey(key)) {
                    result += set2.get(key);
                    continue;
                }
            }

            return result;
        }

        private Map<String, Integer> createMultiSet(String s) {
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length() - 1; i++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i + 1);
                if ('a' <= ch1 && ch1 <= 'z' &&
                        'a' <= ch2 && ch2 <= 'z') {
                    String key = "" + ch1 + ch2;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            return map;
        }
    }
}
