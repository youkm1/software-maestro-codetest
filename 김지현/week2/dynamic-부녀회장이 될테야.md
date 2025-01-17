https://www.acmicpc.net/problem/2775

## 2775. 부녀회장이 될테야

### 풀이 방법
- 입력값으로 첫째줄에는 테스트 케이스의 개수, 그 밑으로는 테스트 케이스 수만큼의 k, n을 준다.
- 아파트 k층 n호에 사는 사람의 수는 k-1층의 1, 2, ..., n호에 사는 사람의 합이므로 다이나믹 프로그래밍을 이용한다.
  - dp배열을 dp[k+1][n+1]으로 만든다.
  - dp배열의 초기값은 0층의 모든 호수 값으로 채워준다.
  - 층은 0부터 시작하고 호수는 1부터 시작하므로 중첩반복문에서 루프변수를 둘다 1로 설정한다.

### 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
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
```