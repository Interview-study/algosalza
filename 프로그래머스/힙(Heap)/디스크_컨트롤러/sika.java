package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class heap2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1000, 1000}}));
    }

    public static int solution(int[][] jobs) {
        final ArrayDeque<Job> jobQueue = Arrays.stream(jobs)
            .map(it -> new Job(it[0], it[1]))
            .sorted()
            .collect(Collectors.toCollection(ArrayDeque::new));
        final PriorityQueue<Job> readyQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.workingTime));

        readyQueue.add(jobQueue.pollFirst());
        int endTime = readyQueue.peek().requestTime;
        int total = 0;

        while (!readyQueue.isEmpty()) {
            final Job current = readyQueue.poll();
            endTime += current.workingTime;
            total += (endTime - current.requestTime);

            while (!jobQueue.isEmpty()
                && (jobQueue.peekFirst().requestTime < endTime)) {
                readyQueue.add(jobQueue.pollFirst());
            }

            if (!jobQueue.isEmpty() && readyQueue.isEmpty()) {
                endTime = jobQueue.peek().requestTime;
                readyQueue.add(jobQueue.pollFirst());
            }
        }
        return total / jobs.length;
    }

    private static class Job implements Comparable<Job> {
        final int requestTime;
        final int workingTime;

        public Job(final int requestTime, final int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(final Job that) {
            if (this.requestTime < that.requestTime) {
                return -1;
            } else if (this.requestTime == that.requestTime) {
                return this.workingTime - that.workingTime;
            } else {
                return 1;
            }
        }
    }
}
