import java.util.*;

public class BiggestNumber {
    public String solution(String number, int k) {
        int targetLength = number.length() - k;

        StringBuilder answer = new StringBuilder(number);

        while (answer.length() > targetLength) {
            for (int i = 0; i < answer.length() - 1; i++) {
                if (answer.charAt(i) < answer.charAt(i + 1)) {
                    answer.deleteCharAt(i);
                    break;
                }
                if (i == answer.length() - 2) {
                    return answer.substring(0, answer.length() - k);
                }
            }
        }

        return answer.toString();
    }
}