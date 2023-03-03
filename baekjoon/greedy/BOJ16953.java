package baekjoon.greedy;

import java.io.*;

public class BOJ16953 {

    static long A, B;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            A = Long.parseLong(split[0]);
            B = Long.parseLong(split[1]);

            int cnt = 1;
            while (A < B) {
                // 1이 아니면서 홀수인 수는 만들어질 수 없다
                if (B % 10 != 1 && B % 2 == 1) {
                    System.out.println(-1);
                    return;
                }
                if (B % 2 == 0) {
                    B = B / 2;
                } else {
                    B = B - 1;
                    B = B / 10;
                }

                cnt++;
            }
            System.out.println(A == B ? cnt : -1);
        }
    }
}
