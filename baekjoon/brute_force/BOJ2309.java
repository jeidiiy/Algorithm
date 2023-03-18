package baekjoon.brute_force;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {

    final static int numOfDwarfs = 9;
    static int[] dwarfs = new int[numOfDwarfs];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i = 0; i < numOfDwarfs; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < numOfDwarfs; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    Arrays.sort(dwarfs);
                    StringBuilder sb = new StringBuilder();
                    for (int k = 2; k < numOfDwarfs; k++)
                        sb.append(dwarfs[k]).append("\n");
                    System.out.print(sb);
                    return;
                }
            }
        }
    }
}
