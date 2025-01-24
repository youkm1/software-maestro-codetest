import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i<= 8; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N); //N을 1번 사용한 경우
        
        for (int i=2;i<=8; i++) {
            for (int j = 1; j<i;j++){
                for (int a : dp.get(j)) {
                    for (int b:dp.get(i-j)) {
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if (b!=0) dp.get(i).add(a/b);
                    }
                }
            }
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            if (dp.get(i).contains(number)) return i;
        }
       return -1;
    }
    
}
