package baekjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1181 {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            // 중복 제거
            Set<String> words = new HashSet<>();

            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }

            List<String> wordsList = new ArrayList<>(words);

            // 사전 순 정렬 후 길이 순 정렬
            wordsList.sort(Comparator.naturalOrder());
            wordsList.sort((s1, s2) -> s1.length() - s2.length());

            for (String word : wordsList) {
                sb.append(word).append('\n');
            }
            bw.write(sb.toString());
        }
    }

}
