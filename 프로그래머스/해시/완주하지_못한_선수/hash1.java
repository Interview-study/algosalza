package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash1 {
    public static void main(String[] args) {
        final String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        final String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        final Map<String, Integer> map = new HashMap<>();
        for (final String s: participant) {
            map.merge(s, 1, Integer::sum);
        }

        for (final String s : completion) {
            map.merge(s, -1, Integer::sum);
        }

        return map.entrySet().stream()
            .filter(it -> it.getValue() == 1)
            .findFirst()
            .get()
            .getKey();
    }
}
