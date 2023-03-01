package baekjoon.set;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ10815 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            Set<Integer> sangeunCards = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            br.readLine();
            List<Integer> cardsForComparing = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            cardsForComparing.stream().forEach(card -> {
                if (sangeunCards.contains(card))
                    sb.append(1).append(" ");
                else
                    sb.append(0).append(" ");
            });
            System.out.println(sb);
        }
    }
}
