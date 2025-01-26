### 문제
When users are authenticated, they are given an authentication token. Unless a token is reset, it expires after a system-wide expiryLimit. If a reset request is received at or before the expiry time, the expiry time is reset to expiryLimit minutes from the time of reset.
1. An unexpired token id can be reset any number of times.
2. A reset issued to a non-existent or an expired token_ id is ignored. 
3. Once a token_id expires it cannot be reused


Command syntax: [type, token_id, T]
- Create command: Type 0 generates a token with id token_ id at time T.
  - Its expiry is set to T + expiryLimit.
- Reset command: Type 1 resets the expiry to T + expiryLimit.

Start with an empty list of tokens. Perform a sequence of requests sorted ascending by their T parameter. Find the number of tokens that are active after all commands have been executed, at the maximum Tof all requests.

Example)
- expiryLimit = 4
- commands = [[0,1, 1], [0,2,2], [1, 1,5],[1,2, 7]]

The maximum time T = 7, so the analysis will end at T = 7. Each time a token is created or reset, its new expiration time will be at time T + 4.

Working through the commands: 
0. [0,1,1] : Create _token _id_ = 1 at time T = 1 and set its expiry to T + _expiryLimit_ = 5.
1. [0,2,2]: Create _token _id_ = 2 with an expiry at T = 6
2. [1,1,5]: Reset _token_id_ = 1 at T = 5. The time is less than or equal to the expiry limit so a new limit is set: 5 + 4 = 9.
3. [1,2,7]: Reset _token_id_ = 2 at T = 7. The id expires at time T = 6, so when the _Reset token_id_ = 2 command comes in at T = 7, it is ignored.


Only _token_id_ = 1 is active at time T = 7. Return 1.

### pseudo code
- 주어진 명령어 목록을 처리하고 최종적으로 활성화된 토큰의 수를 반환해야함
- tokenExpiryMap을 사용하여 각 토큰의 만료 시간을 저장
- 각 명령을 순회하며 토큰을 생성하거나 리셋
- 모든 명령을 처리한 후, maxTime에서 활성화된 토큰의 수를 계산

### 코드
```java
class Result {
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        Map<Integer, Integer> tokenExpiryMap = new HashMap<>();
        int maxTime = 0;
        
        for(List<Interger> command : command) {
            int type = command.get(0);
            int tokenId = command.get(1);
            int time = command.get(2);
            maxTime = Math.max(maxTime, time);
            
            if (type == 0) {
                tokenExpiryMap.put(tokenId, time + expiryLimit);
            } else if (type == 1) {
                Integer expiryTime = tokenExpiryMap.get(tokenId);
                if (expiryTime != null && expiryTime >= time) {
                    tokenExpiryMap.put(tokenId, time + expiryLimit);
                }
            }
        }
        int activeCount = 0;
        for (int expiryTime : tokenExpiryMap.values()) {
            if (expiryTime > maxTime) {
                activeCount++;
            }
        }
        return activeCount;
    }
}
```