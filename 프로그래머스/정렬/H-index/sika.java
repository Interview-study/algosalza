package programmers;

import java.util.Arrays;

public class sort3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0}));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            final int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }

        // 모두 0인 경우
        return 0;
    }
}
