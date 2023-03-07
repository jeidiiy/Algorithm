package baekjoon.array;

import java.io.*;
import java.util.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            Map<String, Integer> namedMap = new HashMap<String, Integer>();
            Map<Integer, String> numberMap = new HashMap<Integer, String>();

            for (int i = 1; i <= N; i++) {
                String pocketmonName = br.readLine();
                namedMap.put(pocketmonName, i);
                numberMap.put(i, pocketmonName);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                String question = br.readLine();
                char first = question.charAt(0);
                if (first >= '0' && first <= '9') {
                    sb.append(numberMap.get(Integer.parseInt(question)));
                } else {
                    sb.append(namedMap.get(question));
                }
                sb.append("\n");
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
