public class WordChange {
    public int solution1(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) return 0;

        List<String> lists = new ArrayList<>(Arrays.asList(words));
        int answer = 0;

        List<String> parents;
        List<String> currents = new LinkedList<>();
        lists.remove(begin);
        currents.add(begin);

        while (lists.size() > 0 && !currents.isEmpty()) {
            parents = currents;
            currents = new LinkedList<>();
            for (String parent : parents) {
                for (String next : lists) {
                    if (isChangable(parent, next)) {
                        if (next.equals(target)) return answer + 1;
                        currents.add(next);
                    }
                }
                lists.removeAll(currents);
            }
            answer++;
        }

        return 0;
    }

    private boolean isChangable(String from, String to) {
        int diff = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return true;
    }

    public int solution2(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) return 0;

        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(begin, 0);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current.level;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangable(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.level + 1));
                }
            }

        }

        return 0;
    }

    class Node {
        String word;
        int level;

        Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
