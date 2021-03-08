package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class dbfs2 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        }));
    }

    public static int solution(int n, int[][] computers) {
        final boolean[] visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += bfs(computers, visited, i);
            }
        }

        return answer;
    }

    public static int bfs(final int[][] computers, final boolean[] visited, final int currentComputer) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(currentComputer);
        visited[currentComputer] = true;

        while (!queue.isEmpty()) {
            final int current = queue.remove();
            for (int next = 0; next < computers.length; next++) {
                if (computers[current][next] == 1 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return 1;
    }
}
