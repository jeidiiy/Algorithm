package baekjoon.greedy;

import java.io.*;

public class BOJ10162 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int[] coins = {300, 60, 10};
        int[] cnts = new int[coins.length];

        if (input % coins[coins.length - 1] != 0) {
            System.out.println(-1);
            return;
        }

        int i = 0;

        for (int coin : coins) {
            cnts[i] = input / coin;
            input %= coin;
            System.out.print(cnts[i] + " ");
            i++;
        }
    }
}
