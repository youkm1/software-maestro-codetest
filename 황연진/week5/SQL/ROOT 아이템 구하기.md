# 문제
SQL 고득점 Kit - ROOT 아이템 구하기 (LV.2)
https://school.programmers.co.kr/learn/courses/30/lessons/273710


# 풀이

```SQL
SELECT I.ITEM_ID, I.ITEM_NAME
FROM ITEM_INFO I
JOIN ITEM_TREE T
ON I.ITEM_ID = T.ITEM_ID
WHERE T.PARENT_ITEM_ID IS NULL
ORDER BY I.ITEM_ID
```


# 해설
* ROOT 아이템 :
  `FROM ITEM_INFO I
  JOIN ITEM_TREE T
  ON I.ITEM_ID = T.ITEM_ID
  WHERE T.PARENT_ITEM_ID IS NULL`
* 아이템 ID를 기준으로 오름차순 정렬 : `ORDER BY I.ITEM_ID`