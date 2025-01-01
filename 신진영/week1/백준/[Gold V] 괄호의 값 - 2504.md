# [Gold V] 괄호의 값 - 2504

## 📍 [문제 및 풀이 코드 링크](https://github.com/Jinyshin/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Gold/2504.%E2%80%85%EA%B4%84%ED%98%B8%EC%9D%98%E2%80%85%EA%B0%92)

## 📍 풀이 방법

- 입력받은 괄호열에서 인덱스로 접근한 문자를 stack 자료구조를 통해 관리: (, [ -> push, ), ] -> 올바른 쌍인지 확인 후 올바르면 pop, 잘못됐으면 return 0;
- 재귀적으로 계산:
  - 만약 () 또는 []라면 바로 2 or 3 값 반환
  - (X)나 [X]라면 2 _ X의값 or 3 _ X의값을 반환
  - X + Y라면 X의값 + Y의값을 반환
- 에러 처리: 중간에 잘못된 괄호 쌍 찾으면 즉시 계산 stop, 0반환

### pseudo code

- String input = (()[[]])([])
- int calculateValue(String input)
- int result = 0; // 최종연산결괏값
- int temp = 1;
- for int i: 0~input.length-1:
  char c = input.charAt(i);
  - if c == (
    - stack.push(c);
    - temp \*= 2;
  - if c == [
    - stack.push(c);
    - temp \*= 3;
  - if c == )
    - // if stack empty || stack.peek() != ( -> return 0;
    - if stack.peek() == ( -> result += temp;
    - temp /= 2;
  - if c == ] - )과 유사한 로직
    \*/

### 🌟 주의사항

- result에 temp를 더하는 조건은 직전 문자가 여는 괄호일 때만 적용해야 함. 안그러면 중첩된 구조에서 불필요하게 중복 값이 추가됨
  - [[[]]] -> 여기서 ]]] 부분에서 계속 temp가 더해진다는 뜻.
- 마지막에 stack에 문자가 남은 채로 반복문이 종료된 경우에 대한 대응을 해줘야 함.
  - ()[[[[] 이런 케이스 대응을 위해.
