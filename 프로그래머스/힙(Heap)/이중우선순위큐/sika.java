package programmers;

import java.util.Objects;
import java.util.TreeSet;

public class heap3 {
    public static void main(String[] args) {
        final int[] solution = solution(new String[] {"I 7","I 5","I -5","D -1"});
        System.out.println(solution[0] + " " + solution[1]);
    }

    public static int[] solution(String[] operations) {
        final TreeSet<Node> sortedQueue = new TreeSet<>();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "D 1":
                    sortedQueue.pollLast();
                    break;

                case "D -1":
                    sortedQueue.pollFirst();
                    break;

                default:
                    sortedQueue.add(new Node(i, Integer.parseInt(operations[i].split(" ")[1])));
                    break;
            }
        }

        return sortedQueue.isEmpty() ? new int[] {0, 0}
        : new int[] {sortedQueue.last().value, sortedQueue.first().value};
    }

    private static class Node implements Comparable<Node> {
        final int idx;
        final int value;

        public Node(final int idx, final int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            final Node node = (Node)o;
            return idx == node.idx &&
                value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, value);
        }

        @Override
        public int compareTo(final Node that) {
            return Integer.compare(this.value, that.value);
        }
    }
}
