package baekjoon.twopointer;

import java.io.*;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 접시 수
        int d = Integer.parseInt(split[1]); // 초밥 가지 수
        int k = Integer.parseInt(split[2]); // 연속으로 먹을 접시 수
        int c = Integer.parseInt(split[3]); // 쿠폰 번호

        int[] sushis = new int[N + k - 1];
        int[] eaten = new int[d + 1];
        eaten[c] = 1;
        int max = 1;

        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            sushis[N + i] = sushis[i];
        }

        int left = 0;
        int right = k;

        for (int i = left; i < right; i++) {
            if (eaten[sushis[i]] == 0) {
                max++;
            }
            eaten[sushis[i]] += 1;
        }

        int result = max;
        for (; right < sushis.length; right++) {
            eaten[sushis[left]] -= 1;
            if (eaten[sushis[left]] == 0)
                result -= 1;
            if (eaten[sushis[right]] == 0)
                result += 1;
            eaten[sushis[right]] += 1;
            max = Math.max(max, result);
            left++;
        }

        System.out.print(max);
    }
}
