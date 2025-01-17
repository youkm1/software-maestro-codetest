package 김지현.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(score[1] + "\n");
        } else {
            int[] dp = new int[n + 1];
            dp[1] = score[1];
            dp[2] = score[1] + score[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
            }

            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
