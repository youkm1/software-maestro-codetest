# 문제
SQL 고득점 Kit - NULL 처리하기 (LV.2)
https://school.programmers.co.kr/learn/courses/30/lessons/59410


# 풀이

```SQL
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```


# 해설
* 아이디 순으로 조회 : `ORDER BY ANIMAL_ID`
* 이름이 없는 동물의 이름은 "No name"으로 표시 : `IFNULL(NAME, 'No name') AS NAME`