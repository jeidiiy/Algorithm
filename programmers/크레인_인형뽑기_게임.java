package programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int move : moves) {
                int column = move - 1;

                for (int row = 0; row < board.length; row++) {
                    int doll = board[row][column];

                    if (doll == 0)
                        continue;
                    else {
                        if (!stack.isEmpty() && stack.peek() == doll) {
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
