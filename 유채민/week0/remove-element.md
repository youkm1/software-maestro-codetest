https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

## 27. Remove Element

### 풀이 방법
단순하게 val이 아닐 때에만 값을 넣어주고 인덱스를 증가시킨다

### 코드
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
```