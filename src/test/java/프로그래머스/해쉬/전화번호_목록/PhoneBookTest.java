package 프로그래머스.해쉬.전화번호_목록;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhoneBookTest {

    @Test
    public void solution() {
        String[] phoneNumbers = {"119", "97674223", "1195524421"};

        PhoneBook phoneBook = new PhoneBook();
        boolean result = phoneBook.solution(phoneNumbers);

        assertEquals(result, false);
    }
}