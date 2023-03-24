package baekjoon.brute_force;

import java.io.*;
import java.util.Arrays;

public class BOJ2003 {



    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (N == 1) {
            System.out.print(nums[0] == M ? 1 : 0);
            return;
        }

        System.out.print(solve());
    }

    private static int solve() {
        int cnt = 0;
        int start = 0, end = 0;
        int sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= nums[start++];
            } else if (end >= nums.length) {
                break;
            } else {
                sum += nums[end++];
            }

            if (sum == M)
                cnt++;
        }

        return cnt;
    }
}
