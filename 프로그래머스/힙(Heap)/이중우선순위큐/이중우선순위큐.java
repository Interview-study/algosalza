package programmers.heap;

import java.util.TreeSet;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] strings = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] solution = solution(strings);
        System.out.println();
    }

    public static int[] solution(String[] operations) {
        // 순서 정렬을 위해 TreeSet을 사용한다.
        TreeSet<Integer> set = new TreeSet<>();

        for (String operation : operations) {
            String[] s = operation.split(" ");
            String op = s[0];
            String value = s[1];

            // 삽입
            if (op.equals("I")) {
                set.add(Integer.valueOf(value));
            } else {
                if (value.equals("1")) {
                    // TreeSet을 사용하므로 Last에는 최대값이 존재한다.
                    set.pollLast();
                } else {
                    set.pollFirst();
                }
            }
        }

        if (set.size() == 0) {
            return new int[]{0, 0};
        }

        return new int[]{set.pollLast(), set.pollFirst()};
    }
}
