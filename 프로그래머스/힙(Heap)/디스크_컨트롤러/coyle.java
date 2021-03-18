package programmers.heap;

import java.util.*;

public class 디스크_컨트롤러 {
    public static void main(String[] args) {
        int[][] ints = {{0, 3}, {2, 9}, {1, 6}};
        int solution = solution(ints);
        System.out.println();
    }

    // CPU 스케줄링 SJF와 비슷하다.
    // SJF는 최소 대기 시간을 보장한다.
    // 단점: 기아 현상 발생 가능
    public static int solution(int[][] jobs) {
        // q에 삽입, start로 정렬된다.
        List<Job> q = new LinkedList<>();
        for (int[] job : jobs) {
            q.add(new Job(job[0], job[1]));
        }
        q.sort(Comparator.comparingInt(o -> o.start));

        // 흘러가는 시간을 표현
        int time = 0;
        // 대기 시간을 더해갈 값
        int wait = 0;
        // poll() 할 때마다 소요 시간이 가장 낮은 Job이 나오는 우선순위 큐
        PriorityQueue<Job> tmpQ;
        Comparator<Job> jobComparator = (o1, o2) -> {
//            // 소요 시간이 같다면 더 기다린 Job이 먼저 나오도록 설정
//            if (o1.time == o2.time) {
//                return Integer.compare(o1.start, o2.start);
//            }
            // 소요 시간이 짧은 Job이 더 빨리 나오도록 설정
            return Integer.compare(o1.time, o2.time);
        };

        // 큐가 비어있다 => 모든 Job이 동작했다.
        while (!q.isEmpty()) {
            // Job.start가 time보다 작아 실행할 수 있는 Job들을 담은 우선순위 큐
            tmpQ = new PriorityQueue<>(jobComparator);
            // 시작할 수 있는 Job tmpQ에 넣기
            for (Job job : q) {
                if (job.start > time) {
                    break;
                }
                // 시작할 수 있는 Job은 Queue에 삽입
                tmpQ.add(job);
            }

            // 해당 시간에 시작할 수 있는 Job이 없을 경우 => time에서 실행할 수 있는 Job이 존재하지 않을 때
            // 즉, 하드 디스크가 일을 하지 않고 시간이 흘러 간다. => 대기 시간에도 변함이 없다.
            if (tmpQ.isEmpty()) {
                time++;
                continue;
            }

            // 시작할 수 있는 값들 중 가장 소요시간이 작은 Job 꺼내기 => 변수명 짓기 힘들다.
            Job job = tmpQ.poll();
            // 기존 큐에서 시작할 수 있는 값 중 가장 소요시간이 작은 Job 제거
            q.remove(job);

            // 대기 시간 더하기
            wait += (time - job.start) + job.time;
            // 지나간 시간 더하기
            time += job.time;
        }

        return wait / jobs.length;
    }

    static class Job {
        private int start;
        private int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return start == job.start && time == job.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, time);
        }
    }
}
