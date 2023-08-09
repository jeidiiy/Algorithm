package programmers;

import java.util.Stack;

public class 괄호_회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                Stack<Character> stack = new Stack<>();
                char first = s.charAt(0);
                s = s.substring(1) + first;

                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);

                    switch (ch) {
                        case ']':
                            if (!stack.isEmpty() && stack.peek() == '[') {
                                stack.pop();
                            } else {
                                stack.push(ch);
                            }
                            break;
                        case ')':
                            if (!stack.isEmpty() && stack.peek() == '(') {
                                stack.pop();
                            } else {
                                stack.push(ch);
                            }
                            break;
                        case '}':
                            if (!stack.isEmpty() && stack.peek() == '{') {
                                stack.pop();
                            } else {
                                stack.push(ch);
                            }
                            break;
                        default:
                            stack.push(ch);
                            break;
                    }
                }

                if (stack.isEmpty()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
