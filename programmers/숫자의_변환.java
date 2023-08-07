package programmers;

public class 숫자의_변환 {
    class Solution {
        public int solution(int n) {
            // 자기 자신은 항상 포함되므로 1로 시작한다.
            int answer = 1;

            // 자신의 절반보다 큰 수와의 합은 항상 자신보다 크므로
            // n의 절반까지만 탐색하여 연산 횟수를 줄인다.
            for (int i = 1; i <= n / 2; i++) {
                int sum = i;
                for (int j = i + 1; j <= n; j++) {
                    sum += j;
                    if (sum > n)
                        break;
                    if (sum == n)
                        answer++;
                }
            }

            return answer;
        }
    }
}
