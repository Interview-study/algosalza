package programmers.greedy;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] ints = {70, 50, 80, 50};
        int limit = 100;
        solution(ints, limit);
        System.out.println();
    }

    public static int anotherSolution1(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i]);
        }

        int count = 0;
        while (queue.size() > 0) {
            if (queue.size() > 1 && queue.getFirst() + queue.getLast() <= limit) {
                queue.removeFirst();
            }
            queue.removeLast();
            count++;
        }

        return count;
    }

    public static int anotherSolution2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        boolean[] visits = new boolean[people.length];
        int count = 0;
        int size = people.length;
        int left = 0;
        int right = people.length - 1;
        while (size > 0) {
            if (visits[left]) {
                left++;
                continue;
            }
            // 남은 것 중 앞에서 가장 작은 값
            int min = people[left];
            visits[left] = true;
            size--;
            // limit - min >= 40: 남은 값이 40 이하면 사람이 탈 수 없기 때문에 무시
            // size != 0: 남은 것이 더 없다면 더 확인할 필요 없다.
            // min + people[left + 1] <= limit: 제일 몸무게가 적은 사람보다 그 다음 적은 사람의 합이 무게 제한보다 낮을 때
            //  => 즉, 다른 사람을 태울 수 있다.
            if (limit - min >= 40 && size != 0 && min + people[left + 1] <= limit) {
                // 무게 제한보다 아래에서 가능한 가장 큰 값을 제거할 수 있다면 제거
                // 효율성 통과를 위해 right left 관리가 확실히 필요함
                for (int i = right; i > left; i--) {
                    if (!visits[i] && people[i] + min <= limit) {
                        right = i;
                        visits[i] = true;
                        size--;
                        break;
                    }
                }
            }
            left++;
            count++;
        }
        return count;
    }
}
