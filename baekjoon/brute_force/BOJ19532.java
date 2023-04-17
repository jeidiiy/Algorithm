package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[3];
        int e = nums[4];
        int f = nums[5];

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((a * i + b * j == c) && (d * i + e * j == f)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
