package programmers;

import java.util.Objects;
import java.util.TreeSet;

public class heap1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {12, 2, 3, 9, 10, 2, 2}, 7));
    }

    public static int solution(int[] scoville, int K) {
        final TreeSet<Food> minHeap = new TreeSet<>();
        for (int i = 0; i < scoville.length; i++) {
            minHeap.add(new Food(scoville[i], i));
        }

        int answer = 0;
        int idx = scoville.length;
        while (true) {
            final Food first = minHeap.pollFirst();
            if (first.scoville >= K) {
                return answer;
            }
            if (first.scoville < K && minHeap.isEmpty()) {
                return -1;
            }
            final Food second = minHeap.pollFirst();
            minHeap.add(new Food(calculateScoville(first.scoville, second.scoville), idx++));
            answer++;
        }
    }

    public static int calculateScoville(final int first, final int second) {
        return first + (second * 2);
    }

    private static class Food implements Comparable<Food> {
        final int scoville;
        final int idx;

        public Food(final int scoville, final int idx) {
            this.scoville = scoville;
            this.idx = idx;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            final Food food = (Food)o;
            return scoville == food.scoville &&
                idx == food.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(scoville, idx);
        }

        @Override
        public int compareTo(final Food that) {
            if (this.scoville < that.scoville) {
                return -1;
            } else if (this.scoville == that.scoville) {
                return Integer.compare(this.idx, that.idx);
            } else {
                return 1;
            }
        }
    }
}
