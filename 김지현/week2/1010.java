package 김지현.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class ConstructeBridge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        int[] M = new int[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N[i] = Integer.parseInt(st.nextToken());
            M[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            int[][] dp = new int[N[i] + 1][M[i] + 1];

            for (int j = 0; j <= M[i]; j++) {
                dp[0][j] = 1;
            }

            for (int k = 1; k <= N[i]; k++) {
                for (int l = 1; l <= M[i]; l++) {
                    dp[k][l] = dp[k][l - 1] + dp[k - 1][l - 1];
                }
            }
            bw.write(dp[N[i]][M[i]] + "\n");
        }

        br.close();
        bw.close();
    }
}
