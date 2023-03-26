package baekjoon.twopointer;

import java.io.*;
import java.util.Arrays;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] temparatures =
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int p = K;

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temparatures[i];
        }

        int MAX = sum;

        while (p < N) {
            sum -= temparatures[p - K];
            sum += temparatures[p];

            MAX = Math.max(MAX, sum);

            p += 1;
        }

        System.out.print(MAX);
    }
}
