https://www.acmicpc.net/problem/19532

## 19532. 수학은 비대면강의입니다

### 풀이 방법
- 정수 a, b, c, d, e, f를 입력으로 받아야하므로 integer 정수 list를 생성함.
  - 시간을 더 줄이기 위해서는 list가 아닌 각각의 int로 받는 게 좋음.
- -999~999 범위의 x, y를 구해야 하므로 해당 범위로 이중반복을 해줌.
- 해당 방정식의 참/거짓 여부를 위해 if문으로 비교함.

### 코드
```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] integer = new int[6];
        for (int i = 0; i < 6; i++) {
            integer[i] = scan.nextInt();
        }

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if (integer[0] * x + integer[1] * y == integer[2] && integer[3] * x + integer[4] * y == integer[5]) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
        scan.close();
    }
}
```