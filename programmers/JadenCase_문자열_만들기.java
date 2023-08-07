package programmers;

public class JadenCase_문자열_만들기 {
    class Solution {
        public String solution(String s) {
            StringBuilder result = new StringBuilder();
            boolean isNewWord = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    result.append(c);
                    isNewWord = true;
                } else if (isNewWord) {
                    result.append(Character.toUpperCase(c));
                    isNewWord = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }

            return result.toString();
        }
    }
}
