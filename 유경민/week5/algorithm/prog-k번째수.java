import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for (int l = 0; l <= commands.length-1; l++) {
            i = commands[l][0];
            j = commands[l][1];
            k = commands[l][2]; 

            for (int m = i-1; m <= j-1; m++) {
                arrList.add(array[m]);
            }
            Collections.sort(arrList);
            
            answer[l] = arrList.get(k-1);
            arrList.clear();
        }
        return answer;
    }
}
