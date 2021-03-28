import java.util.*;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> weights = new ArrayDeque<>();

        for (int weight : people) {
            weights.add(weight);
        }

        while (!weights.isEmpty()) {
            Integer heaviest = weights.pollLast();

            if (!weights.isEmpty() && weights.peekFirst() + heaviest <= limit) {
                weights.pollFirst();
            }

            answer++;
        }

        return answer;
    }
}