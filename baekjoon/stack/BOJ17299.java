package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class BOJ17299 {

    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int MAX = 1_000_000 + 1;
            int[] countsOfAppearence = new int[MAX];
            int[] elems = new int[N];
            int[] answers = new int[N];
            Stack<Integer> stack = new Stack<>();

            String[] tokens = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                elems[i] = Integer.parseInt(tokens[i]);
                countsOfAppearence[elems[i]]++;
            }

            for (int i = 0; i < N; i++) {
                while (!stack.empty()
                        && countsOfAppearence[elems[i]] > countsOfAppearence[elems[stack.peek()]]) {
                    answers[stack.pop()] = elems[i];
                }
                stack.push(i);
            }

            while (!stack.empty()) {
                answers[stack.pop()] = -1;
            }

            Arrays.stream(answers).forEach((answer) -> wrap(() -> bw.write(answer + " ")));

            bw.flush();
        }
    }

    @FunctionalInterface
    public interface ExceptionConsumer {
        void accept() throws Exception;
    }

    public static void wrap(ExceptionConsumer target) {
        try {
            target.accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
