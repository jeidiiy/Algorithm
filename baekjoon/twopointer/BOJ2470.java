package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);

        if (nums[0] >= 1) {
            System.out.print(nums[0] + " " + nums[1]);
            return;
        }
        if (nums[N - 1] <= -1) {
            System.out.print(nums[N - 2] + " " + nums[N - 1]);
            return;
        }

        int left = 0, right = N - 1;
        int minL, minR, MIN;
        minL = minR = MIN = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == 0) {
                System.out.print(nums[left] + " " + nums[right]);
                return;
            }

            int sumAbs = Math.abs(sum);

            if (MIN >= sumAbs) {
                MIN = sumAbs;
                minL = left;
                minR = right;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.print(nums[minL] + " " + nums[minR]);
    }
}
