```java
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    
    private static int[] networks;
    private static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        networks = new int[computers.length];
        for (int i = 0;i < networks.length; i++) {
            networks[i] = i;
        }
            
        for(int i = 0; i < computers.length; i++){
            for(int j = i + 1; j < computers[0].length; j++){
                if (computers[i][j] == 1){
                    int minNetworkNum = Math.min(networks[i], networks[j]);
                    int maxNetworkNum = Math.max(networks[i], networks[j]);
                    connect(maxNetworkNum, minNetworkNum);
                }
            }
        }
        
        Set<Integer> set = new HashSet();
        for (int i = 0; i < networks.length; i++) {
            set.add(networks[i]);
        }
        
        return set.size();
    }
    
    private void connect(int a, int b) {
        for (int i = 0; i < networks.length; i++) {
            if (networks[i] == a) {
                networks[i] = b;
            }
        }
    }
}
```

