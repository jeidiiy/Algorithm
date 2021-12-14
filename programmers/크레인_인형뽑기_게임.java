package programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            /**
             * 스택이 비었을 때 peek() 수행 시 발생하는 예외를 막기 위해
             * isEmpty()를 수행했지만 그냥 0을 하나 넣어둠으로써 불필요한 체크를 제거
             */
            stack.push(0);

            for (int move : moves) {
                int column = move - 1;

                for (int row = 0; row < board.length; row++) {
                    int doll = board[row][column];

                    if (doll == 0)
                        continue;
                    else {
                        if (stack.peek() == doll) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(doll);
                        }
                        board[row][column] = 0;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
