```java
package programmers.greedy;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        solution(4, a);
    }
    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0]));

        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        int island = 1;

        boolean[] visits = new boolean[n];
        visits[0] = true;
        List<Integer> queue = new LinkedList<>();
        int start = 0;
        int answer = 0;

        while (island < n) {
            // 움직일 수 있는 곳 모두 삽입
            for (int i = 0; i < costs.length; i++) {
                if (costs[i][0] == start && visits[costs[i][1]] == false) {
                    if (!queue.contains(costs[i][1])) {
                        queue.add(costs[i][1]);
                    }
                    min[costs[i][1]] = Math.min(min[costs[i][1]], costs[i][2]);
                }
                if (costs[i][1] == start && visits[costs[i][0]] == false) {
                    if (!queue.contains(costs[i][0])) {
                        queue.add(costs[i][0]);
                    }
                    min[costs[i][0]] = Math.min(min[costs[i][0]], costs[i][2]);
                }
            }

            int tmp = Integer.MAX_VALUE;
            for (int i = 0; i < queue.size(); i++) {
                // 이을 수 있는 곳 중 가장 작은 비용
                if (tmp > min[queue.get(i)]) {
                    tmp = min[queue.get(i)];
                    start = queue.get(i);
                }
            }

            answer += tmp;
            visits[start] = true;
            queue.remove((Object) start);
            island++;
        }

        return answer;
    }
}
```
