public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += dfs(i, visited, computers);
            }
        }

        return answer;
    }

    private int dfs(int current, boolean[] visited, int[][] computers) {
        visited[current] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }

        return 1;
    }
}
