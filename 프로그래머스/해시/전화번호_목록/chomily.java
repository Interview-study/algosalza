package 프로그래머스.해쉬.전화번호_목록;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    public boolean solution(String[] phoneBook) {
        Set<String> numbers = new HashSet<>(Arrays.asList(phoneBook));

        if (numbers.size() != phoneBook.length) {
            return false;
        }

        for (String number : phoneBook) {
            for (int i = 1; i < number.length(); i++) {
                if (numbers.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
