package programmers;

public class 점프와_순간_이동 {
    public class Solution {
        public int solution(int n) {
            int answer = 0;

            while (n != 0) {
                if (n % 2 == 1)
                    answer++;
                n /= 2;
            }

            return answer;
        }
    }
}