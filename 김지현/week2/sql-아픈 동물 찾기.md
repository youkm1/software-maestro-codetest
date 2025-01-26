https://school.programmers.co.kr/learn/courses/30/lessons/59036

## 59036. 아픈 동물 찾기

### 풀이 방법
- ANIMAL_INS 테이블에서 아픈 동물의 id, 이름을 조회
  - select문에서 ANIMAL_ID, NAME을 컬럼으로 설정
  - INTAKE_CONDITION이 Sick인 컬럼만 출력

### 코드
```sql
SELECT ANIMAL_ID, NAME from ANIMAL_INS
WHERE INTAKE_CONDITION='Sick';
```