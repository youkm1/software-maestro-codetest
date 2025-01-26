package 김지현.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SugarDeliver {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[3] = 1;
        if (N >= 3) {
            dp[3] = 1;
        }
        if (N >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i - 3] + 1, dp[i]);
            }
            if (dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(dp[N]));
        }
        bw.close();
    }
}
