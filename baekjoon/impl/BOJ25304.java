package baekjoon.impl;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ25304 {
    static int X;
    static int N;
    static int total;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            X = Integer.parseInt(br.readLine());

            N = Integer.parseInt(br.readLine());

            IntStream.range(0, N).forEach((idx) -> {
                try {
                    int[] purchaseInfo = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    total += purchaseInfo[0] * purchaseInfo[1];
                } catch (IOException e) {
                }
            });
        }

        System.out.println(X == total ? "Yes" : "No");
    }
}
