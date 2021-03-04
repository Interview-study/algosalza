package 프로그래머스.해쉬.완주하지_못한_선수;

import java.util.HashMap;

public class NotCompletionPlayer {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> allPlayers = new HashMap<>();

        for (String name : participant) {
            allPlayers.put(name, allPlayers.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            allPlayers.replace(name, allPlayers.get(name) - 1);
        }

        return allPlayers.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(1))
                .findFirst()
                .orElseThrow()
                .getKey();
    }
}
