package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class stackqueue2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3, 1})));
        // 3, 1, 1, 2, 1, 0
    }

    public static int[] solution(int[] prices) {
        final Deque<Integer> stack = new ArrayDeque<>(prices.length);
        stack.addFirst(0);
        Pair min = new Pair(prices[prices.length - 1], prices.length - 1);
        Pair max = new Pair(prices[prices.length - 1], prices.length - 1);

        for (int i = prices.length - 2; i >= 0; i--) {
            int current = prices[i];
            if (current <= min.value) {
                stack.push(prices.length - i - 1);
                min = new Pair(current, i);
                continue;
            }
            if (current > max.value) {
                stack.push(1);
                max = new Pair(current, i);
                continue;
            }

            for (int j = i + 1; j < prices.length; j++) {
                if (current > prices[j]) {
                    stack.push(j - i);
                    break;
                }
            }
        }

        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = stack.pop();
        }
        return answer;
    }

    private static class Pair {
        final int value;
        final int idx;

        public Pair(final int value, final int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
