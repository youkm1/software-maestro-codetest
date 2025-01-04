## Rotate Array

### 풀이 방법
- 배열을 뒤집는 reverse()를 만든다
  - temp에 뒤집기를 시작할 원소를 넣어둔다
  - 뒤집기를 시작할 위치를 start라고 했을 때, start에 end 값을 넣고 end에 temp값(시작값, 즉 end 값이 들어가기 전의 start 값)을 넣는다
  - start값을 앞으로 한 칸, end를 뒤로 한 칸 당긴다 (양 끝에서 중앙으로)
  - start<end까지 해당 작업을 수행한다
- 배열을 전체적으로 1회 뒤집는다
- rotate되지 않을 부분(k~끝)을 1회 뒤집는다
- rotate되어야할 부분(0~k-1)을 1회 뒤집음으로써 다시금 정렬되도록 한다

### 코드
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, k-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```