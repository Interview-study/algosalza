package programmers;

import java.util.Arrays;

public class bruteforce3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }

    public static int[] solution(int brown, int yellow) {
        final int square = brown + yellow;

        for (int row = 3; row < (brown / 2 + 1); row++) {
            for (int col = row; col > 0; col--) {
                if ((row * col == square) && (((2 * row) + (2 * col) - 4) == brown)) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{3, 3};
    }
}
