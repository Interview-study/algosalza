import java.util.Arrays;

public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int start = 1;
        int end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            int current = 0;
            int removedRocks = 0;

            for (int location : rocks) {
                if (location - current < mid) {
                    removedRocks++;
                } else {
                    current = location;
                }
            }

            if (removedRocks > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
