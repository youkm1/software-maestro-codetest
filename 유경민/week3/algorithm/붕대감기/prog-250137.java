import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int maxHealth = health;
        int success = 0;
        int attackIdx = 0;
        
        Map<Integer,Integer> attacksM = new HashMap<>();
        for (int[] attack: attacks) {
            attacksM.put(attack[0],attack[1]);
        }
        
        for (int i = 1; i<=attacks[attacks.length-1][0];i++){
            if (attacksM.containsKey(i)) {
                answer -= attacksM.get(i);
                success = 0;
                if (answer <= 0){
                    return -1;
                }
            } else {
                answer += x;
                success++;
                if (success == t) {
                    answer += y;
                    success = 0;
                }
                if (answer > maxHealth) {
                    answer = maxHealth;
                }
            }
            
        }
        return answer;
    }    
}
