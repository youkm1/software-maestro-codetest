import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        answer = Arrays.stream(strArr)
            .filter(str -> !str.contains("ad"))  //contains되지 않은(false)인 것만 new String[]
            .toArray(String[]::new);
        
        return answer;
    }
}
