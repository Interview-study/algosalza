```java
package programmers.greedy;

import java.util.Stack;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        String solution = solution("1924", 2);
        System.out.println();
    }

    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // stack이 비어있지 않고, stack의 top이 c보다 작을 때, 그리고 k가 0보다 클 때
            // stack의 top이 c보다 작다가 의미하는 게 뭘까?
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static String mySolution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int rest = number.length() - k;
        int right = number.length() - rest;

        while (rest > sb.length() && left < number.length()) {
            int max = -1;
            for (int i = left; i <= right; i++) {
                if (max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    left = i + 1;
                }
            }
            right++;
            sb.append(max);
        }

        return sb.toString();
    }
}

```

