https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

## 169. Majority Element

### 풀이 방법
- sort the array in non-descending order
- return the middle value of the sorted array
  - 정렬된 배열의 중앙 값이 최빈값일 것이라고 가정할 수 있기 때문

### 코드
```java
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length<=2) return nums[0];

        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```

