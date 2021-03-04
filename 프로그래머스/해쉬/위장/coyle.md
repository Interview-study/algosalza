```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap();
        
        for (String[] cloth: clothes) {
            if (!map.containsKey(cloth[1])) {
                map.put(cloth[1], 1);
                continue;
            }
            map.put(cloth[1], map.get(cloth[1]) + 1);
        }
        
        int answer = 1;
        for (Integer clothAmount: map.values()) {
        	// 각 타입을 입지 않았을 경우를 더해준 뒤 곱한다. 
            answer *= (clothAmount + 1);
        }
        // 아무것도 입지 않았을 때
        return answer - 1;
    }
}
```

