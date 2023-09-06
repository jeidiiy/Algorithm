package programmers;

import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();
            answer[answer.length - 1] = -1;
            stack.push(numbers[numbers.length - 1]);

            for (int i = numbers.length - 2; i >= 0; i--) {
                int stackSize = stack.size();

                while (stackSize-- > 0) {
                    int nextNumber = stack.pop();
                    if (nextNumber > numbers[i]) {
                        answer[i] = nextNumber;
                        stack.push(nextNumber);
                        break;
                    }
                }

                stack.push(numbers[i]);

                if (answer[i] == 0) {
                    answer[i] = -1;
                }
            }

            return answer;
        }
    }
}
