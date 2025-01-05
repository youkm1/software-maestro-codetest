https://www.acmicpc.net/problem/2798

## 2798. 블랙잭

### 풀이 방법
- bruteforce를 사용하여 모든 경우의 수를 비교해줌
- n개의 카드를 입력받을 때 m보다 작은 경우를 굳이 비교하지 않음
  - 나중에 n개 카드의 합이 m보다 작은지 비교하기 때문에
- 합이 최대합보다 크면 최대합 값을 변경해줌

### 코드
```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scan.nextInt();
        }

        int maxSum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > maxSum && sum <= m) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
```