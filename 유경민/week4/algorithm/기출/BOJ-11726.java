import java.io.*;

public class Main {
    static long mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        
        //dp[i]=dp[i-1]+dp[i-2]
        for (int i = 3; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % mod;
            
        }
        
        System.out.println(dp[n]);
    }
}
