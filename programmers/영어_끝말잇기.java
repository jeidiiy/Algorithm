package programmers;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = { 0, 0 };
            Set<String> set = new HashSet<>();
            set.add(words[0]);

            for (int order = 1; order < words.length; order++) {
                String currentWord = words[order];

                if (set.contains(currentWord)) {
                    answer[0] = (order % n) + 1;
                    answer[1] = (order / n) + 1;
                    break;
                }

                String prevWord = words[order - 1];
                if (prevWord.charAt(prevWord.length() - 1) != (currentWord.charAt(0))) {
                    answer[0] = (order % n) + 1;
                    answer[1] = (order / n) + 1;
                    break;
                }

                set.add(currentWord);
            }

            return answer;
        }
    }
}
