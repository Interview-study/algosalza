package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class stackqueue4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        final int[] count = new int[10];
        final Deque<Document> documents = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            count[priorities[i]]++;
            documents.addLast(new Document(i, priorities[i]));
        }

        int answer = 0;
        for (int i = 9; i >= 1; i--) {
            while (count[i] != 0) {
                final Document current = documents.removeFirst();
                if (current.priority == i) {
                    answer++;
                    count[i]--;
                    if (current.idx == location) {
                        return answer;
                    }
                    continue;
                }
                documents.addLast(current);
            }
        }

        return answer;
    }

    private static class Document {
        final int idx;
        final int priority;

        public Document(final int idx, final int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
