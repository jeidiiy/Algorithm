package baekjoon.set;

import java.io.*;
import java.util.*;

public class BOJ1269 {

    public static void main(String[] args) throws IOException {
        int N, M = 0;
        ArrayList<Integer> arr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            arr = new ArrayList<>(N);
            split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(split[i]));
            }

            Collections.sort(arr);

            split = br.readLine().split(" ");
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (Collections.binarySearch(arr, Integer.parseInt(split[i])) >= 0)
                    cnt++;
            }

            System.out.print(N + M - cnt * 2);
        }
    }
}
