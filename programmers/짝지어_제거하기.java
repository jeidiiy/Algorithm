package programmers;

import java.util.Stack;

public class 짝지어_제거하기 {
    class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();

            int index = 0;

            while (index < s.length()) {
                Character next = s.charAt(index++);

                if (stack.isEmpty()) {
                    stack.push(next);
                    continue;
                }

                if (next.equals(stack.peek())) {
                    stack.pop();
                    continue;
                }

                stack.push(next);
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}