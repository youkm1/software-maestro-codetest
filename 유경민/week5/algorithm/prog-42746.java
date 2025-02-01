import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNum = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(strNum, (a,b) -> (b+a).compareTo(a+b));
        
        if (strNum[0].equals("0")) return "0";
        
        StringBuilder result = new StringBuilder();
        for (String num:strNum) {
            result.append(num);
        }
        return result.toString();
    }
}
