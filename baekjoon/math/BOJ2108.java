package baekjoon.math;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Arrays.sort(nums);

        Map.Entry<Integer, Integer> mode =
                map.entrySet().stream().max(Comparator.comparing(entry -> entry.getValue())).get();

        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(mode.getValue()))
                .sorted((e1, e2) -> e1.getValue().equals(e2.getValue())
                        ? e1.getKey().compareTo(e2.getKey())
                        : e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        // 산술 평균
        sb.append(Math.round(Arrays.stream(nums).average().getAsDouble())).append("\n");
        // 중간값
        sb.append(nums[N / 2]).append("\n");
        // 최빈값
        sb.append(entries.size() == 1 ? entries.get(0).getKey() : entries.get(1).getKey())
                .append("\n");
        // 범위
        sb.append(nums[N - 1] - nums[0]);

        System.out.print(sb);
    }
}
