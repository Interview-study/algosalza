package programmers.graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 방의_개수 {
    public int solution(int[] arrows) {
        int[][] d = {
                {1, 0},
                {1, 1},
                {0, 1},
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {0, -1},
                {1, -1}
        };

        int r = 0;
        int c = 0;
        Set<Edge> edges = new HashSet<>();
        Set<Point> points = new HashSet<>();
        points.add(new Point(r, c));
        int answer = 0;
        for (int i = 0; i < arrows.length; i++) {
            r += d[arrows[i]][0];
            c += d[arrows[i]][1];

            Point point = new Point(r, c);

            // 간선이 겹칠 때
            Edge edge = new Edge(new Point(r - d[arrows[i]][0], c - d[arrows[i]][1]), point);
            if (edges.contains(edge) || edges.contains(new Edge(point, new Point(r - d[arrows[i]][0], c - d[arrows[i]][1])))) {
                continue;
            }
            edges.add(edge);
            if (arrows[i] == 1) {
                Point start = new Point(r, c - 1);
                Point end = new Point(r - 1, c);
                if (edges.contains(new Edge(start, end)) || edges.contains(new Edge(end, start))) {
                    answer++;
                }
            } else if (arrows[i] == 3) {
                Point start = new Point(r, c - 1);
                Point end = new Point(r + 1, c);
                if (edges.contains(new Edge(start, end)) || edges.contains(new Edge(end, start))) {
                    answer++;
                }
            } else if (arrows[i] == 5) {
                Point start = new Point(r + 1, c);
                Point end = new Point(r, c + 1);
                if (edges.contains(new Edge(start, end)) || edges.contains(new Edge(end, start))) {
                    answer++;
                }
            } else if (arrows[i] == 7) {
                Point start = new Point(r, c + 1);
                Point end = new Point(r - 1, c);
                if (edges.contains(new Edge(start, end)) || edges.contains(new Edge(end, start))) {
                    answer++;
                }
            }

            // 정점이 겹칠 때
            if (!points.contains(point)) {
                points.add(point);
            } else {
                answer++;
            }
        }

        return answer;
    }

    static class Edge {
        private final Point start;
        private final Point end;

        public Edge(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Objects.equals(start, edge.start) && Objects.equals(end, edge.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    static class Point {
        private final int r;
        private final int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
t