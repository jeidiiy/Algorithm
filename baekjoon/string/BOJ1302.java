package baekjoon.string;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String title = br.readLine();
            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            } else {
                map.put(title, 1);
            }
        }

        List<String> keyList = map.keySet().stream().collect(Collectors.toList());

        keyList.sort((title1, title2) -> {
            int result = map.get(title2).compareTo(map.get(title1));
            if (result != 0) {
                return result;
            } else {
                return title1.compareTo(title2);
            }
        });

        System.out.print(keyList.get(0));
    }
}
