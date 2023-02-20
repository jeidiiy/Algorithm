package baekjoon.string;

import java.io.*;

public class BOJ12904 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String S = br.readLine();
            String T = br.readLine();

            while (T.length() > S.length()) {
                if (T.endsWith("A")) {
                    T = T.substring(0, T.length() - 1);
                } else if (T.endsWith("B")) {
                    T = T.substring(0, T.length() - 1);
                    T = new StringBuilder(T).reverse().toString();
                }
            }

            System.out.print(T.equals(S) ? 1 : 0);
        }
    }
}
