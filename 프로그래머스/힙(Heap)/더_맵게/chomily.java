import java.util.*;

/*
* Priority Queue
* 1. 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조 (큐에 들어가는 원소는 비교가 가능한 기준이 있어야함)
* 2. 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음
* 3. 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
* 4. 응급실과 같이 우선순위를 중요시해야 하는 상황에서 쓰임
* */
public class SpicyFood {
    public int solution(int[] scoville, int K) {
        Queue<Integer> mixedScoville = new PriorityQueue<>();

        for (int level : scoville) {
            mixedScoville.add(level);
        }

        try {
            makeSpicier(mixedScoville, K);
            return scoville.length - mixedScoville.size();
        } catch (Exception e) {
            return -1;
        }
    }

    private void makeSpicier(Queue<Integer> mixedScoville, int K) {
        while (mixedScoville.peek() < K){
            Integer firstNotSpicy = mixedScoville.poll();
            Integer secondNotSpicy = mixedScoville.poll();

            mixedScoville.add(firstNotSpicy + secondNotSpicy * 2);
        }
    }
}
