```java
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet();
        
        // 모든 번호를 Set에 삽입
        for (String num: phone_book) {    
            set.add(num);
        }    
        
        // 모든 번호를 순회하면서
        for (String num: phone_book) {    
            Iterator<String> iterator = set.iterator();
            
            while(iterator.hasNext()) {
                String str = iterator.next();
                
                if(num.length() < str.length()) {
                    continue;
                }
                
                // 자신은 생략한다. 
                if(num.equals(str)) {
                    continue;
                }
                
                // 
                if (str.equals(num.substring(0, str.length()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

