package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ10799 {

    static Stack<Character> stack = new Stack<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String expression = br.readLine();

            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(')
                    stack.push(expression.charAt(i));
                else {
                    stack.pop();
                    if (expression.charAt(i - 1) == '(')
                        ans += stack.size();
                    else
                        ans += 1;
                }
            }

            System.out.println(ans);
        }
    }
}
