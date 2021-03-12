package programmers.bfs;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        int[] solution = solution(progresses, speeds);
        System.out.println();
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> q = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Task(progresses[i], speeds[i]));
        }
        List<Integer> answer = new LinkedList();
        while (!q.isEmpty()) {
            q.forEach(Task::progress);

            if (q.peek().isFinish()) {
                q.poll();
                int finish = 1;
                while (!q.isEmpty() && q.peek().isFinish()) {
                    q.poll();
                    finish++;
                }
                answer.add(finish);
            }
        }
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    static class Task {
        private int progress;
        private int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void progress() {
            this.progress += speed;
        }

        public boolean isFinish() {
            return progress >= 100;
        }
    }
}
