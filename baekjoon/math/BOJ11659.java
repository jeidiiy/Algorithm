package baekjoon.math;

import java.io.*;
import java.util.Arrays;

public class BOJ11659 {

    static int N;
    static int M;
    static int[] nums;
    static int[] sums;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            sums = new int[N + 1];
            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 1; i <= N; i++)
                sums[i] = sums[i - 1] + nums[i - 1];

            for (int line = 0; line < M; line++) {
                int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                int start = range[0];
                int end = range[1];
                sb.append(sums[end] - sums[start - 1]).append("\n");
            }

            System.out.print(sb);
        }
    }
}
