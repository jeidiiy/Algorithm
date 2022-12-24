package programmers;

import java.util.Stack;

public class 햄버거_만들기 {

    class Solution {

        private Stack<Integer> ingStack = new Stack<>();

        public int solution(int[] ingredient) {
            int answer = 0;

            for (int ing : ingredient) {
                ingStack.push(ing);

                if (ingStack.size() >= 4) {
                    if (isHamberger()) {
                        answer++;
                        popHamberger();
                    }
                }
            }

            return answer;
        }

        private boolean isHamberger() {
            return (ingStack.get(ingStack.size() - 4) == 1
                 && ingStack.get(ingStack.size() - 3) == 2
                 && ingStack.get(ingStack.size() - 2) == 3
                 && ingStack.get(ingStack.size() - 1) == 1);
        }

        private void popHamberger() {
            ingStack.pop();
            ingStack.pop();
            ingStack.pop();
            ingStack.pop();
        }
    }
}
