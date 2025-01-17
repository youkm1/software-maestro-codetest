# 문제
SQL 고득점 Kit - 상위 n개 레코드 (LV.1)
https://school.programmers.co.kr/learn/courses/30/lessons/59405


# 풀이

```SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1
```


# 해설
* 동물 보호소에 가장 먼저 들어온 동물 : `ORDER BY DATE TIME LIMIT 1`