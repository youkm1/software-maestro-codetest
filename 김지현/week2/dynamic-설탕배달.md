https://www.acmicpc.net/problem/2839

## 2839. 설탕 배달

### 풀이 방법
- 시간효율을 위해 Scanner대신 BufferedReader, BufferedWriter 사용
  - Exception throw를 해줘야 하는 번거로움, String이 아닌 숫자 값은 처리를 해줘야 하는 번거로움이 있음
- 설탕의 무게 N을 입력으로 받음
- 설탕이 3 혹은 5로 나누어 떨어지지 않으면 -1을 리턴
- 배열 dp의 모든 값을 정수의 최대값으로 미리 채워줌
- 다이나믹 프로그래밍 메모이제이션을 사용함
  - i가 3, 5일 때만 초기 값을 1로 지정해주고 i-3, i-5 값을 비교하도록 설정

### 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
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

```