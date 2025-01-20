class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        Long pL = Long.parseLong(p);
        int cnt = 0;
        
        for (int i =0;i<t.length()-len+1;i++){
            String str = t.substring(i,i+len);
            
            if (Long.parseLong(str)<=pL) cnt++;
        }
        return cnt;
    }    
}
    
