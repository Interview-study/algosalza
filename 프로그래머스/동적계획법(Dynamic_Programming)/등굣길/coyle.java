package programmers.dp;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class 등굣길 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 2}};
        int solution = solution(4, 3, a);
        System.out.println();
    }

    // 1000000007로 나누기 안해줘서 시간 초과;;
    public static int solution(int xLimit, int yLimit, int[][] puddles) {
        int[][] dp = new int[yLimit + 1][xLimit + 1];
        for (int[] puddle : puddles) {
            // 1이 x 좌표, 0이 y 좌표
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;
        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[y].length; x++) {
                if (x == 1 && y == 1) {
                    continue;
                }
                if (dp[y][x] == -1) {
                    continue;
                }
                if (y - 1 >= 1 && dp[y - 1][x] != -1) {
                    dp[y][x] += dp[y - 1][x];
                    dp[y][x] %= 1000000007;
                }
                if (x - 1 >= 1 && dp[y][x - 1] != -1) {
                    dp[y][x] += dp[y][x - 1];
                    dp[y][x] %= 1000000007;
                }
            }
        }
        return dp[yLimit][xLimit];
    }

    // 시간 초과 못함
    public static int bfs(int xLimit, int yLimit, int[][] puddles) {
        int[][] roots = new int[yLimit + 1][xLimit + 1];
        for (int[] puddle : puddles) {
            // 1이 x 좌표, 0이 y 좌표
            roots[puddle[1]][puddle[0]] = -1;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        roots[1][1] = 1;
        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            if (x + 1 <= xLimit && roots[y][x + 1] != -1) {
                roots[y][x + 1] += roots[y][x];
                roots[y][x + 1] %= 1000000007;
                if (!q.contains(new Point(y, x + 1))) {
                    q.add(new Point(y, x + 1));
                }
            }
            if (y + 1 <= yLimit && roots[y + 1][x] != -1) {
                roots[y + 1][x] += roots[y][x];
                roots[y + 1][x] %= 1000000007;
                if (!q.contains(new Point(y + 1, x))) {
                    q.add(new Point(y + 1, x));
                }
            }
        }
        return roots[yLimit][xLimit];
    }

    static class Point {

        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
