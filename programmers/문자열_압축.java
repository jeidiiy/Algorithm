package programmers;

public class 문자열_압축 {

    class Solution {
        public int solution(String s) {

            int answer = Integer.MAX_VALUE;

            if (s.length() == 1)
                return 1;

            for (int i = 1; i <= s.length() / 2; i++) {
                String str = "";
                String tmp = "";
                int count = 1;

                for (int j = 0; j < s.length() / i; j++) {
                    if (tmp.equals(s.substring(j * i, (j * i) + i))) {
                        count++;
                        continue;
                    }

                    if (count > 1) {
                        str += count + tmp;
                        count = 1;
                    } else {
                        str += tmp;
                    }

                    tmp = s.substring(j * i, (j * i) + i);
                }

                if (count > 1) {
                    str += count + tmp;
                    count = 1;
                } else {
                    str += tmp;
                }

                if (s.length() % i != 0) {
                    str += s.substring(s.length() - s.length() % i);
                }

                answer = Math.min(answer, str.length());
            }

            return answer;
        }
    }

}
