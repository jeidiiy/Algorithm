package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14888 {

    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int[] ops;
    private static int[] numbers;
    private static int N;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solution(numbers[0], 1);

            System.out.println(MAX);
            System.out.println(MIN);
        }
    }

    public static void solution(int number, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;

                switch (i) {
                    case 0:
                        solution(number + numbers[idx], idx + 1);
                        break;
                    case 1:
                        solution(number - numbers[idx], idx + 1);
                        break;
                    case 2:
                        solution(number * numbers[idx], idx + 1);
                        break;
                    case 3:
                        solution(number / numbers[idx], idx + 1);
                        break;
                }

                ops[i]++;
            }
        }
    }
}
