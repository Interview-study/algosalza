package programmers.heap;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue();
        for (Integer s: scoville) {
            q.add(Integer.valueOf(s));
        }

        while (!q.isEmpty()) {
            Integer first = q.poll();

            // 최소값이 K보다 클 경우 => 모든 값이 K보다 크다.
            if (first >= K) {
                return answer;
            }

            if (q.size() == 0) {
                break;
            }

            // 최소값이 K보다 크지 않을 경우
            // 섞기
            Integer second = q.poll();
            answer++;
            q.add(first + 2 * second);
        }

        return -1;
    }
}
