package baekjoon.twopointer;

import java.io.*;

public class BOJ15961 {

    static int[] sushis;
    static int[] eaten;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int d = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int c = Integer.parseInt(split[3]);
        int max = 0;

        // 초밥 개수 + 연속된 스시 범위를 맨 뒤에 붙이기 위한 k - 1
        sushis = new int[N + k - 1];
        // 먹은 초밥을 확안하기 위한 배열
        eaten = new int[d + 1];
        eaten[c] = 1;
        max = 1; // 쿠폰 초밥 먹은 처리

        // N개만큼 입력받기
        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }

        // 맨 뒤에 앞쪽 스시 붙이기
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
