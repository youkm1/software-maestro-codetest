class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>(); //문자 개수
        Map<Character, Boolean> seen = new HashMap<>();    //이미 처리한 문자 여부
        Deque<Character> stack = new ArrayDeque<>();       //문제 풀이에 사용할 스택

        for (char c:s.toCharArray()) {
            counter.put(c, counter.get(c) == null?1:counter.get(c)+1);      //문자의 개수를 세어서 넣는다
        }
        
        for (char c:s.toCharArray()) {
            counter.put(c, counter.get(c)-1);
            if (seen.get(c) != null && seen.get(c) == true) {
                continue;       //이미 처리한 것이므로 건뛰!
            }
            //스택에 있는 문자가 c(현재 문자)보다 더 뒤에 붙는 문자라면 스택에 있던 걸 빼고 c를 삽입
            while(!stack.isEmpty()&&stack.peek()>c&&counter.get(stack.peek())>0)    
                seen.put(stack.pop(),false);
            stack.push(c);
            seen.put(c,true);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollLast());
        return sb.toString();
       
    }
}
