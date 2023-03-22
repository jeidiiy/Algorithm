package baekjoon.recur;

import java.io.*;
import java.util.Arrays;

public class BOJ1074 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = info[0];
        int r = info[1];
        int c = info[2];

        int size = (int) (Math.pow(2, N));

        solve(size, r, c);
        System.out.print(ans);
    }

    private static void solve(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        // 1사분면
        if (r < size / 2 && c < size / 2) {
            solve(size / 2, r, c);
        } // 2사분면
        else if (r < size / 2 && c >= size / 2) {
            ans += size * size / 4;
            solve(size / 2, r, c - size / 2);
        } // 3사분면
        else if (r >= size / 2 && c < size / 2) {
            ans += (size * size / 4) * 2;
            solve(size / 2, r - size / 2, c);
        } // 4분면
        else {
            ans += (size * size / 4) * 3;
            solve(size / 2, r - size / 2, c - size / 2);
        }
    }
}
