```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {        
        // Map vs 이분탐색
        Map<String, Integer> map = new HashMap();
        
        // 완주자들 넣기
        for(String completeName: completion) {
            // 동명이인일 시 인원 추가
            if (map.containsKey(completeName)) {
                map.replace(completeName, map.get(completeName) + 1);
                continue;
            }
            map.put(completeName, 1);
        }
    
        String answer = "";    
        for(String participantName: participant) {
            if (!map.containsKey(participantName) || map.get(participantName) == 0) {
                answer = participantName;
                break;
            }
            
            map.replace(participantName, map.get(participantName) - 1);
        }        
        return answer;
    }
}
```

