package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class bruteforce2 {
    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        final int[] ints = numbers.chars()
            .map(it -> it - '0')
            .toArray();

        final Set<Integer> numberList = new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            final Permutation permutation = new Permutation(ints.length, i + 1, new int[i + 1], new ArrayList<>());
            permutation.run(ints.clone(), 0);
            for (final List<Integer> l : permutation.getResult()) {
                numberList.add(
                    l.stream()
                    .map(String::valueOf)
                    .collect(Collectors.collectingAndThen(Collectors.joining(), Integer::parseInt))
                );
            }

        }

        int answer = 0;
        for (final int number : numberList) {
            if (checkPrime(number)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean checkPrime(final int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Permutation {
        private final int n;
        private final int r;
        private final int[] now;
        private final List<List<Integer>> result;

        public Permutation(final int n, final int r, final int[] now, final List<List<Integer>> result) {
            this.n = n;
            this.r = r;
            this.now = now;
            this.result = result;
        }

        public void run(final int[] arr, final int depth) {
            if (depth == r) {
                List<Integer> temp = new ArrayList<>();
                for (final int value : now) {
                    temp.add(value);
                }
                result.add(temp);
                return;
            }
            for (int i = depth; i < n; i++) {
                swap(arr, i, depth);
                now[depth] = arr[depth];
                run(arr, depth + 1);
                swap(arr, i, depth);
            }
        }

        public void swap(final int[] arr, final int i, final int j) {
            final int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public List<List<Integer>> getResult() {
            return result;
        }
    }
}
