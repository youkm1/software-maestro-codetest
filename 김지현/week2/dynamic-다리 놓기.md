https://www.acmicpc.net/problem/1010

## 1010. 다리 놓기

### 풀이 방법
- 입력의 첫 줄에는 테스트케이스의 개수가 들어가야 하므로 정수 T를 입력받는다.
- 테스트케이스 수의 길이를 가진 배열 N, M(서쪽 사이트 N개, 동쪽 사이트 M개)을 입력받는다.
- 다리끼리는 겹쳐질 수 없으므로 연결되어 있는지 연결되어 있지 않은지는 다이나믹 프로그래밍으로 구분한다.
  - N과 M을 배열로 갖는 dp를 생성한다.
  - 초기화: 서쪽에 사이트가 0개인 경우 경우의 수는 1이다.
  - 점화식
    - 첫번째 방법: 이미 j−1개의 다리까지 연결된 상태에서 새로운 다리를 추가하지 않는 경우
    - 두번째 방법: j−1개의 다리를 연결한 상태에서 i−1개의 다리를 놓고, 새로운 다리를 j번째 위치에 놓는 경우


### 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
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

```