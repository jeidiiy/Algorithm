package baekjoon.math;

import java.io.*;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        String N = split[0];
        int B = Integer.parseInt(split[1]);
        int digit = 1;
        int ans = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);
            if ('A' <= c && c <= 'Z') {
                ans += (c - 'A' + 10) * digit;
            } else {
                ans += (c - '0') * digit;
            }
            digit *= B;
        }

        System.out.print(ans);
    }
}
