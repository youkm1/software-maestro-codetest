https://www.acmicpc.net/problem/2231

## 2231. 분해합

### 풀이 방법
- N은 M보다 작아야 하므로 반복문의 범위를 제한해줌
- 각 자릿수를 구해야 하므로 n의 복제값인 temp를 선언해줌
  - temp를 10으로 나눈 나머지는 자릿수이므로 sum에 더해줌.
  - temp를 10으로 나눈 값으로 업데이트 해주고, temp가 0이상일 때에만 반복함.
- 생성자가 없을 때에는 0 출력

### 코드
```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();

        for (int n = 0; n < m; n++) {
            int temp = n;
            int sum = n;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            if (sum == m) {
                System.out.println(n);
                return;
            }
        }
        System.out.println(0);
        scan.close();
    }
}

```