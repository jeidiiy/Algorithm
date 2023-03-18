package baekjoon.brute_force;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {

    static int sum = 0;
    final static int numOfDwarfs = 9;
    static int[] dwarfs = new int[numOfDwarfs];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < numOfDwarfs; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        findSpy();
        nogada();
    }

    private static void findSpy() {
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

    private static void nogada() {
        for (int a = 0; a < 9; a++) {
            for (int b = a + 1; b < 9; b++) {
                for (int c = b + 1; c < 9; c++) {
                    for (int d = c + 1; d < 9; d++) {
                        for (int e = d + 1; e < 9; e++) {
                            for (int f = e + 1; f < 9; f++) {
                                for (int g = f + 1; g < 9; g++) {
                                    int sum = dwarfs[a] + dwarfs[b] + dwarfs[c] + dwarfs[d]
                                            + dwarfs[e] + dwarfs[f] + dwarfs[g];
                                    if (sum == 100) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(dwarfs[a]).append("\n");
                                        sb.append(dwarfs[b]).append("\n");
                                        sb.append(dwarfs[c]).append("\n");
                                        sb.append(dwarfs[d]).append("\n");
                                        sb.append(dwarfs[e]).append("\n");
                                        sb.append(dwarfs[f]).append("\n");
                                        sb.append(dwarfs[g]);
                                        System.out.println(sb);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
