package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class dbfs3 {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public static int bfs(final String begin, final String target, final String[] words) {
        final int[] visited = new int[words.length + 1];
        final Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, words.length));
        visited[words.length] = 0;

        while (!queue.isEmpty()) {
            final Pair n = queue.remove();

            for (final Pair next : findNexts(n.value, words)) {
                if (visited[next.index] == 0) {
                    queue.add(next);
                    visited[next.index] = visited[n.index] + 1;
                    if (next.value.equals(target)) {
                        return visited[next.index];
                    }
                }
            }
        }

        return 0;
    }

    public static List<Pair> findNexts(final String value, final String[] words) {
        final List<Pair> nexts = new ArrayList<>();

        final char[] valueChars = value.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            final char[] wordChars = words[i].toCharArray();
            for (int j = 0; j < valueChars.length; j++) {
                if (valueChars[j] != wordChars[j]) {
                    count++;
                }
            }
            if (count == 1) {
                nexts.add(new Pair(words[i], i));
            }
        }

        return nexts;
    }

    public static class Pair {
        final String value;
        final int index;

        public Pair(final String value, final int index) {
            this.value = value;
            this.index = index;
        }
    }
}
