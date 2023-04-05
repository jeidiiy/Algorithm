package baekjoon.twopointer;

import java.io.*;
import java.util.ArrayList;

public class BOJ1644 {

    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        init(N);

        int ans = findSumOfPrime(N);

        System.out.print(ans);
    }

    private static int findSumOfPrime(int N) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;
        int size = primes.size();

        if (N == 1)
            return 0;

        while (left < size && right < size) {
            if (sum < N) {
                sum += primes.get(right++);
            } else if (sum > N) {
                sum -= primes.get(left++);
            } else {
                sum -= primes.get(left++);
                cnt++;
            }
        }

        if (primes.get(right - 1) == N)
            cnt++;

        return cnt;
    }

    private static void init(int N) {
        boolean[] sieve = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (sieve[i] == true)
                continue;

            primes.add(i);
            for (int j = i + i; j <= N; j += i) {
                sieve[j] = true;
            }
        }
    }
}
