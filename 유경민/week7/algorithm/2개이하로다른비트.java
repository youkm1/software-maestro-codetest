import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        
        for (int i = 0; i<numbers.length;i++) {
            long x = numbers[i];
            
            if (x%2==0){
                ans[i] = x +1; 
            } else {
                long bit = 1;
                while ((x & bit) != 0) bit <<= 1; //시프트햇으므로 bit 오른쪽은 0
            
            ans[i] = x + bit - (bit >> 1);  //홀수면 가장 오른쪽(끝)부터 0을 찾아 1로 바꾸고 
            }                               //그의 오른쪽 1은 0으로 바꾼(반면 짝수는 무조건 끝자리가 0)
        }
        return ans;
    }
}
