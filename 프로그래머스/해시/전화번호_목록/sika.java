package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hash2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }
    public static boolean solution(String[] phone_book) {
        final Set<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));

        for (int i = 1; i < 21; i++) {
            final Map<String, Integer> map = new HashMap<>();
            for (final String s : phone_book) {
                if (s.length() < i) {
                    continue;
                }
                System.out.println(s.substring(0, i));
                map.merge(s.substring(0, i), 1, Integer::sum);
            }

            if (map.entrySet().stream()
                .filter(it -> it.getValue() > 1 && phoneSet.contains(it.getKey()))
                .findFirst()
                .isPresent()) {
                return false;
            }
        }

        return true;
    }
}
