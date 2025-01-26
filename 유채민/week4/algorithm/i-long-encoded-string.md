### 문제
Consider a string that consists of lowercase English letters (i.e., [a-z)) only. The following rules are used to encode all of its characters into the string s.

- a is encoded as 1, bis encoded as 2, cis encoded as 3,..., and i is encoded as y.
- j is encoded as 10#, k is encoded as 11#, l is encoded as 12#,..., and z is encoded as 26#.
- If any character occurs two or more consecutively, its count immediately follows the encoded character in parentheses, e.g. 'aa' is encoded as 1(2).

Examples)
- String "abzx"is encoded as s = "1226#24#".
- String "aabccc" is encoded as s = "1(2)23(3)".
- String "wwxyzwww"is encoded as s = "23#(2)24#25#26#23#(3)".

Given an encoded string s, determine the character counts for each letter of the original, decoded string. Return array of 26 integers where index O contains the number of 'a' characters, index 1 contains the number of 'b' characters, and so on.


### pseudo code
1. 초기화
   - 알파벡 빈도를 저장할 크기 26의 리스트 freq를 0으로 초기화
   - 문자열의 현재 위치를 나타내는 인덱스 i를 0으로 설정
2. 문자열 순회
   - i가 문자열 s의 길이보다 작은 동안 반복
   - 두자리 숫자 확인
     - 만약 i+2가 문자열 길이보다 짧고, s[i+2]가 #인 경우:
       - s[i]와 s[i+1]을 결합하여 두자리 숫자 형성. 이를 정수로 변환하여 num에 저장
       - i를 3만큼 증가시켜 다음 문자를 가리키도록 함
   - 한자리 숫자 확인
     - 위 조건에 해당하지 않는 경우
       - s[i]를 정수로 변환하여 num에 저장
       - i를 1만큼 증가
   - 반복 횟수 확인
     - 기본 반복 횟수 count를 1로 설정
     - 만약 i가 문자열 길이보다 작고 s[i]가 ( 인 경우:
       - ( 다음에 오는 숫자를 추출하여 count에 저장
       - ) 이후의 위치로 i를 업뎃
   - 빈도 리스트 업뎃
     - freq의 num-1 인덱스에 count를 더함
3. freq를 반환

### 코드
```java
class Result {
    public static List<Integer> freqency(String s) {
        int[] freq = new int[26];
        int i=0;
        
        while(i < s.length()) {
            if(i+2 < s.length() && s.charAt(i+2) == '#') {
                int num = Integer.parseInt(s.substring(i, i+2));
                i += 3;
                int count = 1;
                
                if(i < s.length() && s.charAt(i) == '(') {
                    int j = i+1;
                    while(j < s.length() && s.charAt(j) != ')') {
                        j++;
                    }
                    count = Integer.parseInt(s.substring(i+1, j));
                    i = j+1;
                }
                freq[num - 1] += count;
            } else {
                int num = s.charAt(i) - '0';
                i++;
                int count = 1;
                if(i < s.length() && s.charAt(i) == '(') {
                    int j = i+1;
                    while (j < s.length() && s.charAt(j) != ')') {
                        j++;
                    }
                    count = Integer.parseInt(s.substring(i+1, j));
                    i = j+1;
                }
                freq[num-1] += count;
            }
        }
        List<Integer> result = new ArraryList<>();
        for(int f : freq) {
            result.add(f);
        }
        return result;
    }
}
```