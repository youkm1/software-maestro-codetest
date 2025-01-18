# 문제
백준 - 귀찮아(SIB) (S5)
https://www.acmicpc.net/problem/14929


# 풀이

```Kotlin
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toLong() }

    val arr = Array<Long>(num + 1) { 0 }
    var sum: Long = 0

    // 누적합 구해서 arr에 저장
    list.forEachIndexed { index, i -> arr[index + 1] = arr[index] + i }
    // 공식에 따라서 공통 인수(list)를 차례로 돌면서 다른 원소들의 합과 곱해지면 된다
    list.forEachIndexed { index, i ->
        sum += i * (arr[num] - arr[index + 1]) }

    println(sum)
}
```


# 해설
* `num = 3`, `x1x2 + x1x3 + x2x3 = x1(x2+x3) + x2(x3)`
* 공통 인수로 나온 원소는 다음 계산에서 제거되며, 그 다음 원소가 공통 인수가 되고 다른 원소들의 합과 곱해지는 규칙
* 누적합을 일단 구해서 배열에 저장해놓고, 받은 `list`를 차례로 돌면서 누적합에서 필요없는 부분만 빼고 값을 곱해서 `sum`에 더하면 된다.