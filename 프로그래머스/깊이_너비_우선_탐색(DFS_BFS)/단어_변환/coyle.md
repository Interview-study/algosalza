```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words에 target이 존재하지 않을 때
        boolean contains = Arrays.asList(words)
                .contains(target);

        if (!contains) {
            return 0;
        }

        // begin 삽입
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        // begin에 사용될 visits 삽입

        while (!q.isEmpty()) {
            Word poll = q.poll();
            if (poll.equals(target)) {
                return poll.getDepth();
            }

            Arrays.stream(words)
                    .filter(poll::isConvertible)
                    .forEach(word -> q.add(new Word(word, poll.depth + 1)));
        }
        
        return 0;

    }

    static class Word {
        private final String value;
        private final int depth;

        public Word(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public boolean isConvertible(String begin) {
            if (begin.length() != value.length()) {
                return false;
            }
            int difference = 0;
            for (int i = 0; i < begin.length(); i++) {
                if (begin.charAt(i) != value.charAt(i)) {
                    if (difference == 1) {
                        return false;
                    }
                    difference++;
                }
            }
            return true;
        }

        public boolean equals(String target) {
            return value.equals(target);
        }

        public String getValue() {
            return value;
        }

        public int getDepth() {
            return depth;
        }
    }
}
```

