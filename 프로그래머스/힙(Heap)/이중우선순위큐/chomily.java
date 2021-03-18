import java.util.*;

public class DoublePriotiryQueue {

    // 중복 값 입력 가능
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            operate(maxHeap, minHeap, operation);
        }

        return new int[]{ maxHeap.peek() == null ? 0 : maxHeap.poll(), minHeap.peek() == null ? 0 : minHeap.poll() };
    }

    private void operate(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, String operation) {
        if (operation.equals("D 1")) {
            Integer max = maxHeap.poll();
            minHeap.remove(max);
        } else if (operation.equals("D -1")) {
            Integer min = minHeap.poll();
            maxHeap.remove(min);
        } else {
            int value = Integer.parseInt(operation.substring(2));
            minHeap.add(value);
            maxHeap.add(value);
        }
    }

    // 중복 값이 없는 경우
    public int[] solution1(String[] operations) {
        TreeSet<Integer> list = new TreeSet<>();

        for (String operation : operations) {
            operate(list, operation);
        }

        if (list.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[]{list.pollLast(), list.pollFirst()};
        }
    }

    private void operate(TreeSet<Integer> list, String operation) {
        if (operation.equals("D 1")) {
            list.pollLast();
        } else if (operation.equals("D -1")) {
            list.pollFirst();
        } else {
            list.add(Integer.parseInt(operation.substring(2)));
        }
    }
}
