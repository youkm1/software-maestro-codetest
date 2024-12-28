https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

## 26. Remove Duplicates from Sorted Array

### 풀이 방법
- index 포인터를 1에 세워둔다
- 배열을 순회하며 다음 값과 같지 않은 nums[i] 값을 찾는다
  - 다음 값인 nums[i+1]과 같지 않다는 건 중복이 끝났다는 말
  - 이 시점에 도달한 경우 인덱스 포인터의 위치에 nums[i+1]값을 넣고 index값은 +1 한다

## 코드
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] != nums[i+1]){
                nums[index++] = nums[i+1];
            }
        }
        return index;
    }
}
```