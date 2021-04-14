package programmers.graph;

import java.util.*;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        int solution = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println();
    }

    public static int solution(int n, int[][] edges) {
        boolean[][] roots = new boolean[n][n];
        for (int[] edge : edges) {
            roots[edge[0] - 1][edge[1] - 1] = true;
            roots[edge[1] - 1][edge[0] - 1] = true;
        }

        int[] mins = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int max = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (int i = 1; i < roots[node].length; i++) {
                if (roots[node][i] && mins[i] == 0) {
                    mins[i] = mins[node] + 1;
                    q.add(i);
                    max = Math.max(max, mins[i]);
                }
            }
        }

        int finalMax = max;
        return (int) Arrays.stream(mins)
                .filter(value -> value == finalMax)
                .count();
    }
}
