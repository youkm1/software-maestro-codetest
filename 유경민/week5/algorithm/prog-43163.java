import java.util.*;

class Solution {
    static class Word {
        String word;
        int count;
        
        Word(String word,int count) {
            this.word=word;
            this.count=count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Word(begin,0));
            
        while (!queue.isEmpty()){
            Word current = queue.poll();
            String curWord = current.word;
            int curCount = current.count;
            
            if (curWord.equals(target)) return curCount;
            for (int i =0; i< words.length;i++){
                if (!visited[i]&&canChange(curWord, words[i])){
                    visited[i] = true;
                    queue.offer(new Word(words[i], curCount + 1));
                }
            }
            
        }
        return 0;
    }
    private boolean canChange(String a, String b) {
        int diff = 0;
        for (int i= 0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
