package programmers;

public class 기사단원의_무기 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            for (int i = 1; i <= number; i++) {
                int cntDivisor = 0;
                for (int j = 1; j * j <= i; j++) {
                    if (j * j == i)
                        cntDivisor++;
                    else if (i % j == 0)
                        cntDivisor += 2;
                }

                answer += cntDivisor > limit ? power : cntDivisor;
            }

            return answer;
        }
    }
}
