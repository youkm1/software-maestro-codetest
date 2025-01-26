import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while (!q.isEmpty()) {
            int[] current = q.poll(); //큐에서 상태 꺼내기
            int sum = current[0];
            int idx = current[1];
            
            if (idx == numbers.length) {  //모든 numbers를 돈 경우
                if (sum == target) {
                    answer++;
                }
                continue;
            }
            //조건을 먼저 확인한 뒤 큐에 상태를 추가하는 것이 더 효율적
            q.offer(new int[]{sum + numbers[idx], idx+1});
            q.offer(new int[]{sum - numbers[idx], idx+1});
        }
        return answer;
    }
}
