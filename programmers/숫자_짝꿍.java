package programmers;

public class 숫자_짝꿍 {
    class Solution {
        public String solution(String X, String Y) {
            int[] x = new int[10];
            int[] y = new int[10];

            for (int i = 0; i < X.length(); i++) {
                x[X.charAt(i) - '0'] += 1;
            }

            for (int i = 0; i < Y.length(); i++) {
                y[Y.charAt(i) - '0'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < Math.min(x[i], y[i]); j++) {
                    sb.append(i);
                }
            }

            if (sb.length() == 0) {
                return "-1";
            }

            if (sb.charAt(0) == '0') {
                return "0";
            }

            String answer = sb.toString();
            return answer;
        }
    }
}
