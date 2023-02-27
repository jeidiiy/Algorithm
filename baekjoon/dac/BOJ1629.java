package baekjoon.dac;

import java.io.*;
import java.util.Arrays;

public class BOJ1629 {

    static long C;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long[] line =
                    Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long A = line[0], B = line[1];
            C = line[2];

            System.out.println(pow(A, B));
        }
    }

    public static long pow(long x, long n) {
        if (n == 1)
            return x % C;

        long tmp = pow(x, n / 2);

        if (n % 2 == 0)
            return tmp * tmp % C;
        else
            return (tmp * tmp % C) * x % C;
    }
}
