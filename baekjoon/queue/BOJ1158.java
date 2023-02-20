package baekjoon.queue;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ1158 {

    static int[] input;
    static int N;
    static int K;
    static Queue<Integer> queue;
    static Queue<Integer> ans;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = input[0];
            K = input[1];

            queue = new LinkedList<>();
            ans = new LinkedList<>();
            IntStream.rangeClosed(1, N).forEach(queue::add);

            while (!queue.isEmpty()) {
                IntStream.rangeClosed(1, K - 1).forEach(idx -> queue.add(queue.remove()));
                ans.add(queue.remove());
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");
            while (!ans.isEmpty()) {
                sb.append(ans.remove()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append(">");

            System.out.print(sb);
        }
    }
}
