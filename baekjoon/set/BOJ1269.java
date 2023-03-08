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
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .forEach(elem -> arr.add(elem));

            Collections.sort(arr);

            long cnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .filter(elem -> Collections.binarySearch(arr, elem) >= 0).count();

            System.out.print(N + M - cnt * 2);
        }
    }
}
