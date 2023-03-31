package baekjoon.dp;

import java.io.*;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stageCount = Integer.parseInt(br.readLine());

        int[] stagesWeights = new int[stageCount + 1];
        int[] dp = new int[stageCount + 1];

        for (int i = 1; i < stageCount + 1; i++) {
            stagesWeights[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stagesWeights[1];

        if (stageCount >= 2)
            dp[2] = stagesWeights[1] + stagesWeights[2];

        for (int i = 3; i < stageCount + 1; i++) {
            dp[i] = stagesWeights[i] + Math.max(dp[i - 2], dp[i - 3] + stagesWeights[i - 1]);
        }

        System.out.print(dp[stageCount]);
    }
}
