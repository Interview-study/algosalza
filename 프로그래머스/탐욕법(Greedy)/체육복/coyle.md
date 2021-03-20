```java
import java.util.*;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            int lostNumber = lost[i];
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lostNumber - 1) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
                if (reserve[j] == lostNumber + 1) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        long count = Arrays.stream(lost)
                .filter(value -> value != -1)
                .count();

        return (int) (n - count);
    }
}
```

