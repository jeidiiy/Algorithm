package programmers;

public class 타겟_넘버 {
    class Solution {
        public int solution(int[] numbers, int target) {
            return dfs(numbers, target, 0, 0);
        }

        private int dfs(int[] numbers, int target, int sum, int current) {
            int result = 0;

            if (current == numbers.length) {
                return target == sum ? 1 : 0;
            }

            result += dfs(numbers, target, sum + numbers[current], current + 1);
            result += dfs(numbers, target, sum + numbers[current] * -1, current + 1);

            return result;
        }
    }
}
