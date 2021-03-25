```java
package programmers.binary.search;

public class 입국심사 {
    public long solution(int n, int[] times) {
        return binarySearch(times, n);
    }

    long binarySearch(int[] times, long targetPerson) {
        long left = 0;
        long right = times[times.length - 1] * targetPerson;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPassed(times, targetPerson, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPassed(int[] times, long targetPerson, long mid) {
        long throughput = 0;
        for (int time : times) {
            throughput += mid / time;
        }
        return throughput >= targetPerson;
    }
}

```

