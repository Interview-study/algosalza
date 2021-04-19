import java.util.*;

public class Rank {
    public int solution(int n, int[][] results) {
        int[][] winLose = new int[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            winLose[winner][loser] = 1;
            winLose[loser][winner] = -1;
        }

        for (int k = 0; k < n + 1; k++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (winLose[i][j] == 0 && winLose[i][k] == winLose[k][j]) {
                        winLose[i][j] = winLose[i][k];
                    }
                }
            }
        }

        return (int)Arrays.stream(winLose)
                .map(eachResult -> Arrays.stream(eachResult).filter(result -> result == 0).count())
                .filter(unknown -> unknown == 2)
                .count();
    }
}