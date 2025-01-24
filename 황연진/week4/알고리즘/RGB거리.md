# 문제
백준 - RGB거리 (S1)
https://www.acmicpc.net/problem/1149


# 풀이

```Kotlin
import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()

    // 순서와 색깔을 저장할 이차원 배열 선언
    val dp = Array(num) { IntArray(3) }

    // 각 칸에 비용 저장
    for (i in 0 until num) {
        val cost = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        dp[i] = cost
    }

    // 규칙에 의해 i의 색은 i-1의 색과 다르므로 두 색 중 더 적은 값을 더하면 됨 
    for(i in 1 until num) {
        dp[i][0] += min(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] += min(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] += min(dp[i - 1][0], dp[i - 1][1])
    }

    // 3개 이상의 값을 비교할 때는 minOf() 사용
    println(minOf(dp[num - 1][0], dp[num - 1][1], dp[num - 1][2]))

}
```


# 해설
* 전 값을 중복하여 사용하고 최솟값을 구하는 문제이므로 `DP`로 풀이
* `i`가 빨강일 경우
  `i - 1`은 초록 또는 파랑
* `i`가 초록일 경우
  `i - 1`은 빨강 또는 파랑
* `i`가 파랑일 경우
  `i - 1`은 빨강 또는 초록
* 규칙에 의해 색이 겹치지만 않으면 되므로 두 값 중 더 적은 값을 더해나가면 최솟값이 된다.
