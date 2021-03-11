package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class stackqueue3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {40, 93, 30, 55, 60, 65}, new int[] {60, 1, 30, 5 , 10, 7})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        final Deque<Integer> progressesQueue = Arrays.stream(progresses)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));
        final Deque<Integer> speedsQueue = Arrays.stream(speeds)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));
        final List<Integer> answer = new ArrayList<>();

        while (!progressesQueue.isEmpty()) {
            final int remaining = progressesQueue.size();

            for (int i = 0; i < remaining; i++) {
                final int progress = progressesQueue.removeFirst();
                final int speed = speedsQueue.removeFirst();
                progressesQueue.addLast(progress + speed);
                speedsQueue.addLast(speed);
            }

            int count = 0;
            for (int i = 0; i < remaining; i++) {
                if (progressesQueue.peekFirst() >= 100) {
                    progressesQueue.removeFirst();
                    speedsQueue.removeFirst();
                    count++;
                    continue;
                }
                break;
            }

            if (count != 0) {
                answer.add(count);
            }
        }

        return answer.stream()
            .mapToInt(it -> it)
            .toArray();
    }
}
