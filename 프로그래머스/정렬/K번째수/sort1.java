package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort1 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (final int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        final List<Integer> answers = new ArrayList<>(commands.length);
        for (final int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(temp);
            answers.add(temp[command[2] - 1]);
        }

        final int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
}
