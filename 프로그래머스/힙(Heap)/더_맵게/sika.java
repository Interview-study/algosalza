package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class heap1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {12, 2, 3, 9, 10, 2, 2}, 7));
    }

    public static int solution(int[] scoville, int K) {
        final Queue<Integer> minHeap = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));

        int answer = 0;
        while (true) {
            final int first = minHeap.remove();
            if (first >= K) {
                return answer;
            }
            if (minHeap.isEmpty()) {
                return -1;
            }
            final int second = minHeap.remove();
            minHeap.add(calculateScoville(first, second));
            answer++;
        }
    }

    public static int calculateScoville(final int first, final int second) {
        return first + (second * 2);
    }
}
