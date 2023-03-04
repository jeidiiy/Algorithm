package baekjoon.set;

import java.io.*;
import java.util.*;

public class BOJ14425 {

    static int N, M;
    static Set<String> set = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            for (int i = 0; i < N; i++)
                set.add(br.readLine());

            int ans = 0;
            for (int i = 0; i < M; i++)
                if (set.contains(br.readLine()))
                    ans++;

            System.out.println(ans);
        }
    }
}
