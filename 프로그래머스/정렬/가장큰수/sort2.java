package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class sort2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(Integer::toString)
            .sorted(new Comparator<String>() {
                @Override
                public int compare(final String o1, final String o2) {
                    return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
                }
            })
            .collect(Collectors.collectingAndThen(Collectors.joining(), sort2::removePrefixZero));
    }

    private static String removePrefixZero(final String s) {
        final char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length() && chars[i] == '0') {
            i++;
        }
        if (i == s.length()) {
            return "0";
        }
        return s.substring(i);
    }
}
