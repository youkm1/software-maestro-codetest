### 문제
The following operations on a string are defined:
- Left Shift: A single circular rotation of the string where the the first character moves to the end and all other characters shift one position to the left.
  - ex) abcde becomes bcdea after one shift
- Right Shift: A single circular rotation of the string where the last character moves to the beginning and all other characters shift one position to the right.
  - ex) abcde becomes eabcd after one right shift

### pseudo code
- leftShifts과 rightShifts을 스트링의 길이로 % 함으로써 shift하는 크기가 스트링 길이를 벗어나지 않도록 한다
- 오른쪽으로 이동해야할 shift 수(netRS, 즉 netRightShift)는 leftShift - rightShift을 통해 구할 수 있다
  - 음수라면 왼쪽으로 shift해야하고 양수라면 오른쪽으로 shift하는 것
  - 음수일 경우 스트링의 길이를 더함으로써 왼쪽으로 이동해야할 수를 구한다
- 스트링의 끝자락(l - netRS)과 앞부분(0, l - netRS)를 합침으로써 최종값을 구한다

### 코드
```java
class Result {
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        int l = s.length();
        if (l == 0) {
            return s;
        }
        
        leftShifts %= l;
        rightShifts %= l;
        
        int netRS = (rightShifts - leftShifts) % l;
        
        if (netRS < 0){
            netRS += l;
        }
        return s.substring(l - netRS) + s.substring(0, l - netRS);
    }
}
```