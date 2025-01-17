https://school.programmers.co.kr/learn/courses/30/lessons/59405

## 59405. 상위 n개 레코드

### 풀이 방법
- ANIMAL_INS 테이블에서 가장 먼저 들어온 동물의 이름을 조회
  - 이름을 조회할 컬럼으로 설정
  - DATETIME을 기준으로 오름차순 정렬
  - 상위 1개만 출력

### 코드
```sql
SELECT NAME from ANIMAL_INS
order by DATETIME asc
limit 1;
```