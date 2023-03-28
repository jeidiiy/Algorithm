package baekjoon.twopointer;

import java.io.*;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);

        int[] nums = new int[N + 1];
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        int left = 0, right = 0;

        int MAX = 100_000;
        int MIN = MAX;
        int sum = 0;

        while (left <= N && right <= N) {
            if (sum >= S && MIN > right - left)
                MIN = right - left;

            if (sum < S)
                sum += nums[right++];
            else
                sum -= nums[left++];
        }

        System.out.print(MIN == MAX ? 0 : MIN);
    }
}
