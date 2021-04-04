import java.util.*;

public class SpeedCamera {
    public int solution(int[][] routes) {
        int answer = 1;
        boolean[] cars = new boolean[routes.length];
        Arrays.sort(routes, Comparator.comparingInt(it -> it[0]));

        int cameraLocation = routes[0][1];
        cars[0] = true;

        for (int i = 1; i < routes.length; i++) {
            cars[i] = true;
            if (routes[i][0] > cameraLocation) {
                answer++;
                cameraLocation = routes[i][1];
            }
            if (routes[i][1] < cameraLocation) {
                cameraLocation = routes[i][1];
            }
        }

        return answer;
    }
}