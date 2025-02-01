# 문제
백준 - DFS와 BFS (S2)
https://www.acmicpc.net/problem/1260


# 풀이

```Kotlin
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    // n + 1 이유 : 정점번호는 1부터 시작하기 때문에 정점 번호와 인덱스를 맞추려고
    val graph = Array(n + 1) { ArrayList<Int>() }
    val dfsVisited = BooleanArray(n + 1) { false }
    val bfsVisited = BooleanArray(n + 1) { false }

    val dfsResult = ArrayList<Int>()
    val bfsResult = ArrayList<Int>()

    // 노드 - (연결 노드 리스트) 형태로 저장
    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(end)
        graph[end].add(start)
    }

    // 작은 노드부터 DFS / BFS 해야하므로 ArrayList 오름차순 정렬
    for (i in 1..n) {
        graph[i].sort()
    }

    fun DFS(node: Int) {
        // 함수에 들어왔단 것은 해당 노드를 방문했다는 것이므로 결과에 추가
        dfsResult.add(node)
        // 방문했으므로 다시 방문하지 않게 방문 배열 true
        dfsVisited[node] = true

        // 그래프 돌면서 방문하지 않은 연결 노드가 있다면 재귀
        for (i in graph[node]) {
            if (!dfsVisited[i]) {
                DFS(i)
            }
        }
    }

    fun BFS(node: Int) {
        val queue = ArrayList<Int>()
        // 큐에 추가
        queue.add(node)
        // 방문했으므로 다시 방문하지 않게 방문 배열 true
        bfsVisited[node] = true

        // 큐가 빌 때까지 반복
        while (queue.isNotEmpty()) {
            // 큐에서 첫번째 노드 제거
            val cur = queue.removeFirst()
            // 큐에 들어왔단 것은 해당 노드를 방문했다는 것이므로 결과에 추가
            bfsResult.add(cur)

            // 그래프 돌면서 방문하지 않은 연결 노드가 있다면 연결 노드 모두 방문
            for (j in graph[cur]) {
                if (!bfsVisited[j]) {
                    queue.add(j)
                    bfsVisited[j] = true
                }
            }
        }
    }

    DFS(v)
    BFS(v)

    dfsResult.forEach { print("$it ") }
    println()
    bfsResult.forEach { print("$it ") }
}
```


# 해설
* `DFS` / `BFS`
* 간선이 양방향이므로 그래프에 저장할 때 거꾸로도 저장해주어야 함
* 값을 저장하면 정점 번호가 뒤섞여있기 때문에 작은 것부터 탐색하기 위해 오름차순 `sort`
* `DFS` 함수, `BFS` 함수 만들어서 시작 정점 번호인 `v`로 함수 시작