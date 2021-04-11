import java.util.Arrays;

public class Triangle {
    public int solution(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i != 0) {
                    int leftParent = 0, rightParent = 0;
                    if (j - 1 >= 0) {
                        leftParent = triangle[i - 1][j - 1];
                    }
                    if (j <= i - 1) {
                        rightParent = triangle[i - 1][j];
                    }

                    triangle[i][j] = Math.max(leftParent, rightParent) + triangle[i][j];
                }
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}