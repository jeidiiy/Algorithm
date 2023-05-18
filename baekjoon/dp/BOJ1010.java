import java.util.*;
import java.io.*;

public class BOJ1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            String[] split = br.readLine().split(" ");

            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            dp = new int[M + 1][M + 1];

            int answer = combination(M, N);
            System.out.println(answer);
        }
    }

    public static int combination(int N, int R) {
        if (dp[N][R] > 0) {
            return dp[N][R];
        }

        if (N == R || R == 0) {
            return dp[N][R] = 1;
        }

        return dp[N][R] = combination(N - 1, R) + combination(N - 1, R - 1);
    }
}
