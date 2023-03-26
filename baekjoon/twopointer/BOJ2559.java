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

        int pA = K;
        int pB = K - 1;

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temparatures[i];
        }

        int MAX = sum;
        boolean isATurn = true;

        while (pA < N && pB < N) {
            sum -= isATurn ? temparatures[pA - K] : temparatures[pB - K];
            sum += isATurn ? temparatures[pA] : temparatures[pB];

            MAX = Math.max(MAX, sum);

            if (isATurn) {
                pB = pA + 1;
            } else {
                pA = pB + 1;
            }

            isATurn = !isATurn;
        }

        System.out.print(MAX);
    }
}
