```java
class Solution {
    public int[] solution(int brown, int yellow) {
        // x + y - 2 ==> a
        int a = brown / 2;
        // xy ==> b
        int b = yellow + 2 * a;
        for (int i = 3; i < 2_500; i++) {
            for (int j = 3; j < 2_500; j++) {
                if (i + j - 2 == a && i * j == b) {
                    return new int[]{j, i};
                }
            }
        }
        
        throw new IllegalArgumentException("잘못된 값이 들어왔습니다.");
    }
}
```

