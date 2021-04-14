import java.util.*;

public class Nodes {
    public int solution(int n, int[][] edge) {
        int[] distances = new int[n + 1];
        List<Integer>[] edges = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distances[i] = -1;
            edges[i] = new LinkedList<>();
        }

        for (int[] vertex : edge) {
            int node1 = vertex[0];
            int node2 = vertex[1];
            edges[node1].add(node2);
            edges[node2].add(node1);
        }

        int maxDistance = bfs(distances, edges);

        return (int)Arrays.stream(distances).filter(it -> it == maxDistance).count();
    }

    public int bfs(int[] distances, List<Integer>[] edges) {
        int distance = 0;
        distances[1] = 0;
        Set<Integer> nodes = new HashSet<>(edges[1]);

        while (!nodes.isEmpty()) {
            distance++;
            Set<Integer> temp = nodes;
            nodes = new HashSet<>();
            for (int connected : temp) {
                if (distances[connected] == -1) {
                    distances[connected] = distance;
                    nodes.addAll(edges[connected]);
                }
            }
        }

        return distance - 1;
    }
}