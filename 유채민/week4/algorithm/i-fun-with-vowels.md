### 문제
A subsequence is a sequence derived from another string by deleting some or no characters without changing the order of the remaining characters. For example, "aeiou" is the subsequence of the English alphabet that contains all vowels. Given a string, determine the length of the longest subsequence that includes all these vowels in order and does not include any vowels out of order.

Examples)
s = 'aeeiiouu'
All 5 vowels are present in the correct order, and none are misplaced.
The length of the entire string, 8, is returned.

s = 'aeeiiaouu'
Again, all 5 vowels are present in the correct order, but the 'a' at position 5 must be removed since it is out of order. The subsequence
'aeeiiouu' has a length of 8.

**Funtion Description**
- Complete the function longestVowe/Subsequence in the editor below.
- longestVowelSubsequence has the following parameter(s):
  - s: the string to analyze

**Returns**
- int: the length of the longest subsequence within the input string that contains all of the vowels in order or 0 if there is no such subsequence

**Constraints**
- 5< |s| <5 × 10^5
- Each character of string se {a, e, i, o, u}

### pseudo code
- 모음 배열 v (vowels) 저장
- 카운터 배열 c (counts) 배열 생성
  - 각 모음의 최대 부분 수열의 길이 저장
  - c[0]: a의 개수
  - c[1]: e의 개수 등등
- 문자열 s를 순회하며 현재 문자가 v에 포한된 경우
  - c[i]를 갱신
    - 만약 i가 0, 즉 a라면 c[0]을 1증가
    - 그렇지 않을 경우 c[i]를 c[i-1]의 값에 1을 더한 값과 현재 c[i]값 중 최댓값으로 갱신
- 결과 반환
  - 최종적으로 c[4]를 반환하는데, 이는 u까지 포함된 가장 긴 부분 수열의 길이를 나타냄
  - 만약 c[4]가 0이라면 이는 모든 모음이 순서대로 포함되지 않은것이기에 0을 반환함

### 코드
```java
class Result {
    public static int longestVowelSubsequence(String s) {
        int[] c = new int[5];
        char[] v = {'a', 'e', 'i', 'o', 'u'};
        
        for(char ch : s.toCharArray()) {
            for(int i=0; i<5; i++) {
                if (ch == v[i]) {
                    if(i==0) {
                        c[i]++;
                    } else if (c[i-1] > 0) {
                        c[i] = Math.max(c[i], c[i-1] + 1);
                    }
                }
            }
        }
        return c[4] > 0 ? c[4] : 0;
    }
}
```