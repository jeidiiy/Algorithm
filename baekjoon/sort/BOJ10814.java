package baekjoon.sort;

import java.io.*;
import java.util.*;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<String>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Integer age = Integer.parseInt(split[0]);
            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(split[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer age : map.keySet()) {
            ArrayList<String> names = map.get(age);
            for (int i = 0; i < names.size(); i++) {
                sb.append(age).append(" ").append(names.get(i)).append("\n");
            }
        }
        sb.delete(sb.length() - 1, sb.length());

        System.out.print(sb);
    }
}
