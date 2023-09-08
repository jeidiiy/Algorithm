package programmers;

import java.util.Set;
import java.util.HashSet;

public class 둘만의_암호 {
    class Solution {
        public String solution(String s, String skip, int index) {
            Set<Character> skipSet = new HashSet<>();

            for (int i = 0; i < skip.length(); i++) {
                skipSet.add(skip.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                for (int count = 0; count < index; count++) {
                    ch = ch == 'z' ? 'a' : ++ch;
                    if (skipSet.contains(ch)) {
                        count--;
                    }
                }

                sb.append(ch);
            }

            return sb.toString();
        }
    }
}
