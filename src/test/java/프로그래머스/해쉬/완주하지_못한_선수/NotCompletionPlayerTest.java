package 프로그래머스.해쉬.완주하지_못한_선수;

import org.junit.Test;

public class NotCompletionPlayerTest {

    @Test
    public void solution() {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        NotCompletionPlayer notCompletionPlayer = new NotCompletionPlayer();
        String result = notCompletionPlayer.solution(participant, completion);

        assert (result).equals("mislav");
    }
}