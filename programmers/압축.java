package programmers;

import java.util.List;
import java.util.ArrayList;

public class 압축 {
    class Solution {
        public int[] solution(String msg) {
            List<String> dict = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < 26; i++) {
                dict.add(String.valueOf((char) ('A' + i)));
            }

            for (int i = 0; i < msg.length(); i++) {
                for (int j = dict.size() - 1; j >= 0; j--) {
                    if (msg.substring(i).startsWith(dict.get(j))) {
                        i += dict.get(j).length() - 1;
                        result.add(j + 1);
                        if (i + 1 < msg.length()) {
                            dict.add(dict.get(j) + msg.charAt(i + 1));
                        }
                        break;
                    }
                }
            }

            int[] answer = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }
    }
}