package baekjoon.twopointer;

import java.io.*;

public class BOJ1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        int left = 1, right = 2;

        StringBuilder sb = new StringBuilder();
        while (left < right) {
            int diff = (int) (Math.pow(right, 2) - Math.pow(left, 2));
            if (diff > G)
                left++;
            else if (diff < G)
                right++;
            else {
                sb.append(right).append("\n");
                left++;
                right++;
            }
        }
        if (sb.length() == 0)
            sb.append(-1).append("\n");

        sb.delete(sb.length() - 1, sb.length());

        System.out.print(sb);
    }
}
