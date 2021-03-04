package 프로그래머스.정렬.가장_큰_수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxNumber {

    public String solution(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }

        if (total == 0) {
            return "0";
        }

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((num1, num2) -> -(num1 + num2).compareTo(num2 + num1))  // num1 = 6, num2 = 61
                .collect(Collectors.joining());
    }
}
