package programmers;

import java.util.List;
import java.util.ArrayList;

public class 모음사전 {
    class Solution {
        private final String[] VOWELS = { "A", "E", "I", "O", "U" };
        private final int MAX = 5;

        public int solution(String word) {
            List<String> dict = new ArrayList<>();

            for (int i = 0; i < MAX; i++) {
                dfs(dict, VOWELS[i]);
            }

            return dict.indexOf(word) + 1;
        }

        private void dfs(List<String> dict, String str) {
            if (str.length() > MAX) {
                return;
            }

            dict.add(str);

            for (int i = 0; i < VOWELS.length; i++) {
                dfs(dict, str + VOWELS[i]);
            }
        }
    }
}
