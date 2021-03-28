package programmers.dp;

import java.util.Arrays;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int[][] maxTriangle = new int[triangle.length][triangle.length];
        maxTriangle[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    maxTriangle[i][j] = maxTriangle[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    maxTriangle[i][j] = maxTriangle[i - 1][j - 1] + triangle[i][j];
                } else {
                    maxTriangle[i][j] = Math.max(maxTriangle[i - 1][j - 1], maxTriangle[i - 1][j]) + triangle[i][j];
                }
            }
        }

        return Arrays.stream(maxTriangle[triangle.length - 1])
                .max()
                .getAsInt();
    }
}
