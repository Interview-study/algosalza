package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash3 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
            {"yellowhat", "headgear"},
            {"bluesunglasses", "eyewear"},
            {"green_turban", "headgear"}
        }));
    }

    public static int solution(String[][] clothes) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.merge(clothes[i][1], 1, Integer::sum);
        }

        return map.entrySet().stream()
            .mapToInt(it -> it.getValue() + 1)
            .reduce((a, b) -> a * b)
            .getAsInt() - 1;
    }
}
