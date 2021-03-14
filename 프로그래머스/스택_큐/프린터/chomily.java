import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        Queue<Integer> readyDocs = new LinkedList<>();

        for (int priority : priorities) {
            readyDocs.add(priority);
        }

        while (!readyDocs.isEmpty()) {
            Integer currentDocs = readyDocs.poll();

            if (isMostUrgent(readyDocs, currentDocs) && (location % priorities.length) == 0) {
                return priorities.length - readyDocs.size();
            }

            if (!isMostUrgent(readyDocs, currentDocs)) {
                readyDocs.add(currentDocs);
            }

            location = (location == 0) ? readyDocs.size() - 1 : location - 1;
        }

        throw new IllegalStateException();
    }

    public boolean isMostUrgent(Queue<Integer> readyDocs, int currentDocs) {
        return readyDocs.stream().noneMatch(it -> it > currentDocs);
    }
}
