import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> idxM = new HashMap<>();
        List<String> playerList = new ArrayList<>(Arrays.asList(players));
        
        for (int i = 0; i < players.length; i++) idxM.put(players[i],i);
        for (String call:callings) {
            int currentIdx = idxM.get(call);
            if(currentIdx > 0) {
                String prev = playerList.get(currentIdx - 1);
                
                playerList.set(currentIdx - 1,call);
                playerList.set(currentIdx, prev);
                
                idxM.put(call, currentIdx - 1);
                idxM.put(prev, currentIdx);
            }
        }
        return playerList.toArray(new String[0]); //플레이어리스트 크기에 맞게 자동할당
    }
}
