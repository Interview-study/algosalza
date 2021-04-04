public class Immigration {
    public long solution(int n, int[] times) {
        long max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        return countTimes(n, times, 0, max * (long)n);
    }

    public long countTimes(int people, int[] times, long start, long end) {
        if (start >= end) {
            return end;
        }

        long mid = (end + start) / 2;
        long capacity = 0;
        for (int time : times) {
            capacity += mid / time;
        }

        if (capacity < people) {
            return Math.min(Long.MAX_VALUE, countTimes(people, times, mid + 1, end));
        } else {
            return Math.min(mid, countTimes(people, times, start, mid));
        }
    }
}
