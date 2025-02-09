class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        if (count >= 1) {
            long moneyToSum = 0;
            for (int i = 1;i<= count;i++) {
                moneyToSum += price * i;
            }
            answer = moneyToSum - money;
            
            if (answer <= 0) answer = 0;

        }
       
        return answer;
    }
}
