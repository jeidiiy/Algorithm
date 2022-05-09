package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1439 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int countForZero = 0;
        int countForOne = 0;
        char prev = '0';

        if (input[0] == '1') {
            countForOne = 1;
            prev = '1';
        } else {
            countForZero = 1;
            prev = '0';
        }

        for (int i = 1; i < input.length; i++) {
            char current = input[i];
            if (current != prev) {
                if (current == '0') {
                    countForZero += 1;
                } else {
                    countForOne += 1;
                }
                prev = current;
            }
        }

        int result = countForZero > countForOne ? countForOne : countForZero;

        System.out.println(result);

    }
}
