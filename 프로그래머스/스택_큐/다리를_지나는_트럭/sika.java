package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class stackqueue1 {
    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[] {10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        final Deque<Integer> waitingTrucks = Arrays.stream(truck_weights)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));
        final Bridge bridge = new Bridge(new ArrayDeque<>(), bridge_length, weight);

        // 첫 번째 트럭
        bridge.cross(waitingTrucks.removeFirst());
        int time = 1;

        // 모든 트럭 다리에 올리기
        time += crossAllTrucks(waitingTrucks, bridge);

        // 모든 트럭 건니기
        while (!bridge.isEmpty()) {
            bridge.cross(0);
            time++;
        }
        return time;
    }

    private static int crossAllTrucks(final Deque<Integer> waitingTrucks, final Bridge bridge) {
        int time = 0;

        while (!waitingTrucks.isEmpty()) {
            final int nextTruck = waitingTrucks.removeFirst();
            if (bridge.canCross(nextTruck)) {
                bridge.cross(nextTruck);
            } else {
                waitingTrucks.addFirst(nextTruck);
                bridge.cross(0);
            }
            time++;
        }

        return time;
    }

    private static class Bridge {
        private final Deque<Integer> trafficConditions;
        private final int length;
        private final int weightLimit;

        private int currentTrucks;
        private int currentWeight;

        public Bridge(final Deque<Integer> trafficConditions, final int length, final int weightLimit) {
            this.trafficConditions = trafficConditions;
            for (int i = 0; i < length; i++) {
                this.trafficConditions.addLast(0);
            }
            this.length = length;
            this.weightLimit = weightLimit;
            this.currentTrucks = 0;
            this.currentWeight = 0;
        }

        public void cross(final int truckWeight) {
            final int first = trafficConditions.removeFirst();
            if (first != 0) {
                this.currentWeight -= first;
                this.currentTrucks--;
            }

            trafficConditions.addLast(truckWeight);
            if (truckWeight != 0) {
                this.currentWeight += truckWeight;
                this.currentTrucks++;
            }
        }

        public boolean canCross(final int truckWeight) {
            return (
                (this.currentTrucks < length)
                    || (trafficConditions.peekFirst() != 0)
            ) && (this.currentWeight - trafficConditions.peekFirst() + truckWeight)
                <= weightLimit;
        }

        public boolean isEmpty() {
            return this.currentTrucks == 0;
        }

        public Deque<Integer> getTrafficConditions() {
            return trafficConditions;
        }
    }
}
