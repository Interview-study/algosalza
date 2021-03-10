```java
class Solution {
    
    private static int answer = 0;
    private static int[] NUMBERS;
    private static int TARGET;
    
    public int solution(int[] numbers, int target) {
        NUMBERS = numbers;
        TARGET = target;
        
        dfs(0, 0);
        
        return answer;
        
    }
    
    public void dfs(int index, int sum) {
        if (NUMBERS.length == index) {
            if (sum == TARGET) {
                answer++;
            }
            return;
        }
        // 더하는 경우
        dfs(index + 1, sum + NUMBERS[index]);
            
        // 빼는 경우 
        dfs(index + 1, sum - NUMBERS[index]);
    }
}
```

