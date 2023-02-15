package baekjoon.math;

import java.io.*;
import java.util.Arrays;

public class BOJ3003 {

    static int[] defaultChessPieces = {1, 1, 2, 2, 2, 8};
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .forEach(foundChessPieces -> System.out
                            .print((defaultChessPieces[idx++] - foundChessPieces) + " "));
        }
    }
}
