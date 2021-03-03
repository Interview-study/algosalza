package 프로그래머스.정렬.K번째수;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int commandCount = commands.length;
        int[] answer = new int[commands.length];

        for (int i = 0; i < commandCount; i++) {
            int[] cutArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(cutArray);
            answer[i] = cutArray[commands[i][2] - 1];
        }

        return answer;
    }
}
