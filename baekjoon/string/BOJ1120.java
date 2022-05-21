package baekjoon.string;

import java.io.*;

public class BOJ1120 {

    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            String A = inputs[0];
            String B = inputs[1];

            int min = Integer.MAX_VALUE;

            int diffOfLength = B.length() - A.length();
            for (int i = 0; i < diffOfLength + 1; i++) {
                int count = 0;
                String tmp = B.substring(i);
                for (int j = 0; j < A.length(); j++) {
                    if (A.charAt(j) != tmp.charAt(j))
                        count++;
                }
                min = Math.min(min, count);
            }

            System.out.println(min);
        }
    }
}
