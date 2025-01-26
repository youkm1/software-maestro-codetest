package 김지현.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class PresidentOfTheWomensAssociation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] k = new int[T];
        int[] n = new int[T];

        for (int i = 0; i < T; i++) {
            k[i] = Integer.parseInt(br.readLine());
            n[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < T; i++) {
            int[][] dp = new int[k[i] + 1][n[i] + 1];
            for (int j = 1; j <= n[i]; j++) {
                dp[0][j] = j;
            }

            for (int p = 1; p <= k[i]; p++) {
                for (int j = 1; j <= n[i]; j++) {
                    dp[p][j] = dp[p][j - 1] + dp[p - 1][j];
                }
            }
            bw.write(dp[k[i]][n[i]] + "\n");
        }

        br.close();
        bw.close();
    }
}
