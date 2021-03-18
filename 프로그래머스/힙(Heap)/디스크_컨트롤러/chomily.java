import java.util.*;

public class DiscController {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> sortedJobs = new PriorityQueue<>(Comparator.comparing(Job::getInputTime));
        for (int[] job : jobs) {
            sortedJobs.add(new Job(job));
        }

        PriorityQueue<Job> readyJobs = new PriorityQueue<>(Comparator.comparing(Job::getDuration));

        int totalTime = 0;
        int now = sortedJobs.peek().getInputTime();
        while (!sortedJobs.isEmpty() || !readyJobs.isEmpty()) {
            prepare(sortedJobs, readyJobs, now);

            Job job;
            if (!readyJobs.isEmpty()) {
                job = readyJobs.poll();
            } else {
                job = sortedJobs.poll();
            }

            int duration = job.getDuration();
            int inputTime = job.getInputTime();

            if (now > inputTime) {
                totalTime += (now - inputTime);  // 대기 시간
            } else if (inputTime > now) {
                now += (inputTime - now);  // 작업이 없던 시간
            }

            now += duration;
            totalTime += duration;
        }

        return totalTime / jobs.length;
    }

    private void prepare(PriorityQueue<Job> sortedJobs, PriorityQueue<Job> readyJobs, int now) {
        while (!sortedJobs.isEmpty() && sortedJobs.peek().isReady(now)) {
            Job job = sortedJobs.poll();
            readyJobs.add(job);
        }
    }

    class Job {
        private final int inputTime;
        private final int duration;

        public Job(int[] job) {
            this.inputTime = job[0];
            this.duration = job[1];
        }

        public boolean isReady(int now) {
            return inputTime <= now;
        }

        public int getInputTime() {
            return inputTime;
        }

        public int getDuration() {
            return duration;
        }
    }
}
