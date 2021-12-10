package baekjoon.impl;

import java.io.*;
import java.util.*;

public class BOJ1292 {

    private static ArrayList<Integer> nums = new ArrayList<>(1010);

    public static void main(String[] args) throws IOException {

        int idx = 0;
        loop: for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++, idx++) {
                if (idx >= 1001)
                    break loop;
                nums.add(i);
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line = br.readLine();
            String[] token = line.split(" ");

            int start = Integer.parseInt(token[0]);
            int end = Integer.parseInt(token[1]);
            int result = 0;

            for (int i = start - 1; i < end; i++) {
                result += nums.get(i);
            }
            System.out.println(result);
        }
    }
}