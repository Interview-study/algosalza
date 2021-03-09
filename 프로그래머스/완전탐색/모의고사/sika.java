package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bruteforce1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,3,2,4,2})));
    }

    public static int[] solution(int[] answers) {
        final int[] firstChoice = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        final Queue<Integer> first = makeChoice(firstChoice);

        final int[] secondChoice = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        final Queue<Integer> second = makeChoice(secondChoice);

        final int[] thirdChoice = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        final Queue<Integer> third = makeChoice(thirdChoice);

        int[] count = new int[3];
        for (final int answer : answers) {
            if (mark(first, answer)) {
                count[0]++;
            }
            if (mark(second, answer)) {
                count[1]++;
            }
            if (mark(third, answer)) {
                count[2]++;
            }
        }

        final int max = Arrays.stream(count).max().getAsInt();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                result.add(i + 1);
            }
        }

        return result.stream()
            .mapToInt(it -> it)
            .toArray();
    }

    private static Queue<Integer> makeChoice(final int[] firstChoice) {
        final Queue<Integer> first = new LinkedList<>();
        for (final int c : firstChoice) {
            first.add(c);
        }
        return first;
    }

    private static boolean mark(final Queue<Integer> queue, final int rightAnswer) {
        final int value = queue.remove();
        queue.add(value);

        return value == rightAnswer;
    }
}
