# [Silver II] 지구 온난화 - 5212

## 📍 [문제 및 풀이 코드 링크](https://github.com/Jinyshin/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Silver/5212.%E2%80%85%EC%A7%80%EA%B5%AC%E2%80%85%EC%98%A8%EB%82%9C%ED%99%94)

## 📍 풀이 방법

- 현재 지도 currMap의 각 칸을 탐색하면서 afterMap 생성하기
  - 'X'-> 그 칸의 상하좌우를 확인하고 '.'의 개수를 센다. (경계칸일때도 ++): countWater()
    - if countWater() < 3 -> afterMap 'X'
    - else afterMap '.'
  - '.'-> 그대로 '.'
- afterMap 출력: afterMap의 'X'들의 최대, 최소 x, y 좌표를 찾고, 해당 범위를 출력한다.
