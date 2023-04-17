package baekjoon.set;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class BOJ7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> s = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] split = br.readLine().split(" ");
            String name = split[0];
            String state = split[1];

            if (state.charAt(0) == 'e')
                s.add(name);
            else
                s.remove(name);
        }

        String[] names = s.toArray(new String[0]);
        Arrays.sort(names, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
