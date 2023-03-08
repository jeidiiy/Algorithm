package baekjoon.set;

import java.io.*;
import java.util.*;

public class BOJ1269 {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();

            Arrays.stream(br.readLine().split(" ")).forEach(s -> set.add(s));
            Arrays.stream(br.readLine().split(" ")).forEach(s -> {
                if (set.contains(s))
                    set.remove(s);
                else
                    set.add(s);
            });

            System.out.print(set.size());
        }

    }
}
