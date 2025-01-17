# 문제
SQL 고득점 Kit - Python 개발자 찾기 (LV.1)
https://school.programmers.co.kr/learn/courses/30/lessons/276013


# 풀이

```SQL
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = "Python" OR SKILL_2 = "Python" OR SKILL_3 = "Python"
ORDER BY ID
```


# 해설
* Python 스킬을 가진 개발자 : `WHERE SKILL_1 = "Python" OR SKILL_2 = "Python" OR SKILL_3 = "Python"`
* ID 기준 오름차순 : `ORDER BY ID`