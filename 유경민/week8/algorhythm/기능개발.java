import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        int[] days = new int[progresses.length];
        int count = 1;
        for (int i = 0; i< progresses.length; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            q.offer(days[i]);
        }
        int first = q.poll(); //제거
        
        while (!q.isEmpty()) {
            int next = q.peek();
            
            if (first >= next) {
                count++;
                q.poll(); //제거
            } else {
                list.add(count);
                count = 1;
                first = q.poll();
            }
        }    
        list.add(count);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
