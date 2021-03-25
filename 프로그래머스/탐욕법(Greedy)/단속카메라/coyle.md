```java
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[][] ints = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        solution(ints);
        System.out.println();
    }

    public static int solution(int[][] routes) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            sorted.add(routes[i]);
        }
        Collections.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int answer = 0;
        while (!sorted.isEmpty()) {
            int[] car = sorted.get(0);
            int carOut = car[1];

            sorted.removeIf(ints -> (ints[0] <= carOut && carOut <= ints[1]));
            answer++;
        }
        return answer;
    }

    /*public static int solution(int[][] routes) {
        // 방문 체크
        boolean[] visits = new boolean[routes.length];
        // 각 인덱스별 통과하는 차량수
        Map<Integer, Integer> amounts = new HashMap<>();
        // 각 인덱스별 통과하는 차량들
        Map<Integer, ArrayList<Integer>> cars = new HashMap<>();
        for (int car = 0; car < routes.length; car++) {
            for (int route = routes[car][0]; route <= routes[car][1]; route++) {
                // 각 인덱스 별 통과하는 차량수 계산
                amounts.put(route, amounts.getOrDefault(route, 0) + 1);
                // 각 인덱스 별 통과하는 차량 삽입
                if (!cars.containsKey(route)) {
                    cars.put(route, new ArrayList<>());
                }
                cars.get(route).add(car);
            }
        }

        int answer = 0;
        while (true) {
            // 차량수가 가장 높은 루트 찾기
            int maxSpot = Integer.MIN_VALUE;
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : amounts.entrySet()) {
                if (entry.getValue() > max) {
                    maxSpot = entry.getKey();
                    max = entry.getValue();
                }
            }

            System.out.println(maxSpot);
            // 차량수가 가장 높은 루트에 있는 차가 방문한 곳 모두 제거
            ArrayList<Integer> maxSpotCars = cars.get(maxSpot);
            for (int i = 0; i < maxSpotCars.size(); i++) {
                Integer carIndex = maxSpotCars.get(i);
                visits[carIndex] = true;
                for (int j = routes[carIndex][0]; j <= routes[carIndex][1]; j++) {
                    if (amounts.containsKey(j)) {
                        amounts.put(j, amounts.get(j) - 1);
                    }
                    if (cars.containsKey(j)) {
                        cars.get(j).remove(carIndex);
                    }
                }
            }
            answer++;
            // 모든 차를 다 감시카메라로 찍었는지
            boolean clear = true;
            for (int i = 0; i < visits.length; i++) {
                if (!visits[i]) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                return answer;
            }
        }
    }*/
}
```

