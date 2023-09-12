package programmers;

public class 두개_이하로_다른_비트 {
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                long num = numbers[i];

                if (num % 2 == 0) {
                    answer[i] = num + 1;
                    continue;
                }

                long next = num;
                int count = 0;
                while (next % 2 == 1) {
                    count++;
                    next /= 2;
                }

                answer[i] = (long) (num + Math.pow(2, count - 1));
            }

            return answer;
        }
    }
}
