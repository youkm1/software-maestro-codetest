https://school.programmers.co.kr/learn/courses/30/lessons/59035

## 59035. 역순 정렬하기

### 풀이 방법
- ANIMAL_INS 테이블에서 동물의 이름과 보호 시작일을 조회
  - select문에서 NAME과 DATETIME을 컬럼으로 설정
- 역순으로 출력해야 하므로 order by desc를 사용

### 코드
```sql
SELECT NAME, DATETIME from ANIMAL_INS
order by ANIMAL_ID desc;
```