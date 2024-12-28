## 80. Remove Duplicates from Sorted Array II

### 풀이 방법
- edge case: 2 duplicates can be kept edge case will be when nums.length <=2
- index will show where the next number will be placed
- look back two positions (index-2) to see if there are two or more duplicates
- index will return the value of k

### 코드
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;

        int index = 2;
        for(int i=2; i<nums.length; i++) {
            if(nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
```