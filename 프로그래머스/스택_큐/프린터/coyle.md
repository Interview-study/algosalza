```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < priorities.length; i++){
            q.add(priorities[i]);
        }
        
        while(!q.isEmpty()){
            boolean isCheck = false;
            Integer first = q.getFirst();
            for(int i = 1; i < q.size(); i++){
                if(first < q.get(i)){
                    isCheck = true;
                    break;
                }
            }
            
            if(isCheck){
                q.removeFirst();
                q.add(first);
                
                if(location == 0){
                    location = q.size() - 1;  
                } else {
                    location--;
                }
                continue;
            }
            
            answer++;
            q.removeFirst();
            if(location == 0) {
                return answer;
            }
            location--;
        }
        throw new IllegalArgumentException();
    }
}
```

