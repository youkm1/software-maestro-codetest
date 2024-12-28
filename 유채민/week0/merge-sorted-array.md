https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

## 88. Merge Sorted Array

### 풀이 방법
- Two pointer 사용
  - 시간 복잡도: O(m+n)
  - 공간 복잡도: O(1)
  - 정렬을 위해 한번의 반복문과 포인터를 이용해 두 개의 배열을 순회함과 동시에 정렬한다
- nums1의 유효 인덱스로 포인터 i 저장
- nums2의 유효 인덱스로 포인터 j 저장
- nums1의 가장 마지막 인덱스로 포인터 k 저장

=> nums1 배열의 가장 큰 값과 nums2 배열에서 가장 큰 값을 비교해서 큰 값은 가장 큰 요소이므로 nums1의 가장 마지막 인덱스부터 앞쪽으로 저장

### 코드
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n -1;

        while (j >= 0) {
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
```