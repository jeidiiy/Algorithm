package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] towers =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] answer = new int[N];

            for (int i = towers.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                    answer[stack.pop()] = i + 1;
                }
                stack.push(i);
            }

            Arrays.stream(answer).forEach(receiveTower -> wrap(() -> bw.write(receiveTower + " ")));

            bw.flush();
        }
    }

    @FunctionalInterface
    public interface IOExceptionConsumer {
        void accept() throws IOException;
    }

    public static void wrap(IOExceptionConsumer target) {
        try {
            target.accept();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
