package baekjoon.queue;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ1158 {

    static int[] input;
    static int N;
    static int K;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = input[0];
            K = input[1];

            list = new ArrayList<>();
            IntStream.rangeClosed(1, N).forEach(list::add);

            sb.append("<");
            int remove = 0;
            while (list.size() != 1) {
                remove = (remove + K - 1) % list.size();
                sb.append(list.get(remove)).append(", ");
                list.remove(remove);
            }
            sb.append(list.get(0)).append(">");

            System.out.print(sb);
        }
    }
}
