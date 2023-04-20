package baekjoon.array;

import java.io.*;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int i = 1; i <= 9; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(split[j - 1]);
                if (MAX < num) {
                    MAX = num;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.print(MAX + "\n" + row + " " + col);
    }
}
