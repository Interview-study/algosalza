package 프로그래머스.정렬.H_Index;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        int total = citations.length;
        int max = Math.min(total, citations[total - 1]);

        for (int h = 1; h <= max; h++) {
            if (citations[total - h] >= h) {
                answer = h;
            } else {
                return answer;
            }
        }

        return answer;
    }
}
