class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0; // cards1의 인덱스
        int index2 = 0; // cards2의 인덱스
        
        for (String word : goal) {
            // cards1에서 단어를 찾고 인덱스를 올림
            if (index1 < cards1.length && cards1[index1].equals(word)) {
                index1++;
            } 
            // cards2에서 단어를 찾고 인덱스를 올림
            else if (index2 < cards2.length && cards2[index2].equals(word)) {
                index2++;
            } 
            // 어느 쪽에도 일치하지 않으면 실패
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
