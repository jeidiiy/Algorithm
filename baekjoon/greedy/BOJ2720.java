package baekjoon.greedy;

import java.io.*;

public class BOJ2720 {

    final static int[] units = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());
            sb.append(calcCoins(C)).append("\n");
        }

        System.out.print(sb);
    }

    private static String calcCoins(int C) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < units.length; i++) {
            int count = C / units[i];
            sb.append(count).append(" ");
            C = C % units[i];
        }

        return sb.toString();
    }
}
