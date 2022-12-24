package programmers;

public class 크기가_다른_부분_문자열 {
    class Solution {
        public int solution(String t, String p) {
            int answer = 0;

            int lengthOfP = p.length();
            int lengthOfT = t.length();
            long longP = Long.parseLong(p);

            for (int i = 0; i <= lengthOfT - lengthOfP; i++) {
                long subT = Long.parseLong(t.substring(i, i + lengthOfP));
                if (subT <= longP)
                    answer++;
            }

            return answer;
        }
    }
}
