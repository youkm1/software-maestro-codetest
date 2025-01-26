### 문제
The data analysts of Hackerland want to schedule some long-running tasks on remote servers optimally to minimize the cost of running them locally. The analysts have two servers, a paid one and a free one. The free server can be used only if the paid server is occupied.

The ith task is expected to take time[i] units of time to complete and the cost of processing the task on the paid server is cost[i]. The task can be run on the free server only if some task is already running on the paid server. The cost of the free server is 0 and it can process any task in 1 unit of time.
Find the minimum cost to complete all the tasks if tasks are scheduled optimally.

Example)
Suppose n = 4, cost = [1, 1, 3, 4] and time = [3, 1, 2, 3)

The first task must be scheduled on the paid server for a cost of 1 and it takes 3 units of time to complete. In the meantime, the other three tasks are executed on the free server for no cost as the free server takes only 1 unit to complete any task. Return the total cost, 1.

**Function Description**
The function getMinCost has the following parameter:
- int cost[n]: the costs of scheduling the tasks on a remote server
- int time [n]: the times taken to run the tasks on a remote server

**Return**
- int: the minimum cost to complete all the tasks

### pseudo code
1. 작업 인덱스 정렬
   - 작업의 인텍스를 저장하는 리스트 생성
   - 이 인데스 리스트를 작업의 비용(cost)을 기준으로 오름차순 정렬
2. 비용 계산
   - 총 비용을 0으로 초기화
   - 작업 인덱스 리스트를 순회하면서:
     - 현재 작업을 유료 서버에 할당하고 해당 비용을 총 비용에 추가
     - 현재 작업의 시간 동안 무료 서버에서 처리할 수 있는 작업 수를 계산
     - 무료 서버에서 처리할 수 있는 작업 수만큼 다음 작업을 건너뜀


### 코드
```java
class Result {
    public static int getMinCost(List<Integer> cost, List<Integer> time) {
        int n = cost.size();
        List<Integer> s = new ArrayList<>();
        for (int i=0; i<n; i++) {
            s.add(i);
        }
        s.sort(Comparator.comparingInt((Integer i) -> cost.get(i))
                .thenComparing(Comparator.comparingInt((Integer i) -> time.get(i)).reversed()));
        
        int tc = 0;
        int i = 0;
        
        while(i<n) {
            int currentI = s.get(i);
            tc += cost.get(currentI);
            int freeT = time.get(currentI);
            i++;
            i+=freeT;
        }
        return tc;
    }
}
```