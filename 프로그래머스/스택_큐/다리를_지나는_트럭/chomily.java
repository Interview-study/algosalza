import java.util.*;

public class BridgeCrossing {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);

        int index = 0;
        int time = 0;
        while (index == 0 || !bridge.isClean()) {
            int nextTruck = 0;
            if (index < truck_weights.length) {
                nextTruck = truck_weights[index];
            }

            bridge.move();

            if (bridge.tryToLoad(nextTruck)) {
                index++;
            }
            time++;
        }

        return time;
    }

    class Bridge {
        private final Queue<Integer> bridgeStatus = new LinkedList<>();
        private final int threshold;
        private int totalWeight = 0;

        Bridge(int bridgeLength, int threshold) {
            for (int i = 0; i < bridgeLength; i++) {
                bridgeStatus.add(0);
            }
            this.threshold = threshold;
        }

        public void move() {
            totalWeight -= bridgeStatus.poll();
        }

        public boolean tryToLoad(int nextTruck) {
            if ((totalWeight + nextTruck) <= threshold) {
                bridgeStatus.add(nextTruck);
                totalWeight += nextTruck;
                return true;
            } else {
                bridgeStatus.add(0);
                return false;
            }
        }

        public boolean isClean() {
            return totalWeight == 0;
        }
    }
}
