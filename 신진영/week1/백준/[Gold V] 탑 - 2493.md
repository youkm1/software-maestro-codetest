# [Gold V] 괄호의 값 - 2504

## 📍 [문제 및 풀이 코드 링크](https://github.com/Jinyshin/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Gold/2493.%E2%80%85%ED%83%91)

## 📍 풀이 방법

- 입력값 처리: 탑의 개수와 높이를 입력받음. 높이는 공백 기준으로 분리하여 처리함. BufferedReader & Writer 활용
- 스택 초기화: (탑의 번호, 높이)를 저장할 스택을 선언함.
- 탑 비교 로직:
  - 현재 탑의 높이 vs 스택에 저장된 탑들의 높이 비교
  - 스택의 탑높이 < 현재 탑높이 -> pop
- 수신탑 결정:
  - stack empty -> 0 저장
  - else
    - stack.push현재 탑의 (번호, 높이)
- 결과 출력: BufferedWriter를 활용.

### pseudo code

- N <- top 개수, heights
- 초기화
  - Stack<int[]> stack, int[N] result
- for i: 0~N-1:
  - height <- heights[i]
  - while(stack is not empty && stack.peek()[1] <= height):
    stack.pop()
  - if stack is empty:
    - result[i] = 0; // 신호 수신 탑 없음
  - else
    - result = stack.peek()[0] // 신호 수신 탑 번호 저장
  - stack.push((i+1, height)) // 현재 탑 정보 push

### 🌟 고민지점

- 처음에는 stack에 탑의 높이만 저장하고, 각 탑의 인덱스를 탑 번호로 사용하려 했는데, 스택에서 탑 제거하면 탑 정보가 사라지고, 탐색을 위해 인덱스를 움직여야 하므로 복잡하고 헷갈림.
- stack의 구조를 (탑 번호, 탑 높이)로 변경해서 더 직관적으로 문제를 해결할 수 있게 됨.
