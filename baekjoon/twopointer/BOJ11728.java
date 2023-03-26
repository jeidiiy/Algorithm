package baekjoon.twopointer;


import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] ans = new int[N + M];

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int pA = 0;
        int pB = 0;
        int pAns = 0;

        while (pA < N && pB < M) {
            if (A[pA] < B[pB]) {
                ans[pAns++] = A[pA++];
            } else {
                ans[pAns++] = B[pB++];
            }
        }

        if (pA == N) {
            System.arraycopy(B, pB, ans, pAns, M - pB);
        } else {
            System.arraycopy(A, pA, ans, pAns, N - pA);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.print(sb);
    }
}
