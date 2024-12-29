https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150

## 209. Minimum Size Subarray Sum

### 풀이 방법
- Sliding Window 문제라고 기술되어있으나 array 크기가 동적으로 변한다
- start, end 두 개의 포인터를 사용하며, end 포인터는 배열의 끝 쪽으로 이동하고, 앞 포인터는 윈도우의 합이 조건에 부합할 때만 이동한다
- 배열의 길이는 ans에 저장하는데, 윈도우의 길이가 최대한 짧아야하니 Math.min을 사용한다
  - sum이 조건에 부합하지 않는 경우 ans는 초기값(Integer 최대값)에서 변화가 없을 것이며 그럴 경우 0을 반환한다


### 코드
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(end < nums.length) {
            sum += nums[end++];
            while (sum >= target) {
                ans = Math.min(ans, end-start);
                sum -= nums[start++];
            }
        }
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;

    }
}
```