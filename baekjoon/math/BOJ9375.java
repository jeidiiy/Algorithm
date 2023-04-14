package baekjoon.math;

import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            Map<String, Set<String>> map = new HashMap<>();
            int numOfClothes = Integer.parseInt(br.readLine());

            while (numOfClothes-- > 0) {
                String[] split = br.readLine().split(" ");
                String name = split[0];
                String type = split[1];
                if (map.containsKey(type)) {
                    map.get(type).add(name);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(name);
                    map.put(type, set);
                }
            }

            int ans = 1;

            for (Set<String> value : map.values()) {
                ans *= value.size() + 1;
            }

            sb.append(ans - 1).append("\n");
        }
        System.out.print(sb);
    }
}
