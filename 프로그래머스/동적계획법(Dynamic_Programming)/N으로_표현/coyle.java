package programmers.dp;

import java.util.ArrayList;
import java.util.HashSet;

public class N으로_표현 {
    public static void main(String[] args) {
        int solution = mySolution(5, 12);
        System.out.println(solution);
    }

    public static int mySolution(int N, int number) {
        if (number == N) {
            return 1;
        }
        ArrayList<Integer>[] dp = new ArrayList[9];
        dp[1] = new ArrayList<>();
        dp[1].add(N);
        HashSet<Integer> visits = new HashSet<>();
        for (int i = 2; i < 9; i++) {
            // N이 5일 경우 5, 55, 555, 5555가 여기서 더해진다.
            dp[i] = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }
            int append = Integer.parseInt(sb.toString());
            for (int first = 1; first < i; first++) {
                for (int second = 1; second < i; second++) {
                    if (first + second != i) {
                        continue;
                    }
                    for (int firstIndex = 0; firstIndex < dp[first].size(); firstIndex++) {
                        for (int secondIndex = 0; secondIndex < dp[second].size(); secondIndex++) {
                            Integer firstEle = dp[first].get(firstIndex);
                            Integer secondEle = dp[second].get(secondIndex);
                            int plus = firstEle + secondEle;
                            // 마이너스는 양쪽 값이 달라질 수 있으므로 두 번
                            int minus1 = firstEle - secondEle;
                            int minus2 = secondEle - firstEle;
                            int multiple = firstEle * secondEle;
                            // 마이너스는 양쪽 값이 달라질 수 있으므로 두 번
                            int devide1 = firstEle / secondEle;
                            int devide2 = secondEle / firstEle;
                            if (append == number || plus == number || minus1 == number || minus2 == number || multiple == number || devide1 == number || devide2 == number) {
                                return i;
                            }
                            add(dp, visits, i, append);
                            add(dp, visits, i, plus);
                            add(dp, visits, i, minus1);
                            add(dp, visits, i, minus2);
                            add(dp, visits, i, multiple);
                            add(dp, visits, i, devide1);
                            add(dp, visits, i, devide2);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static void add(ArrayList<Integer>[] dp, HashSet<Integer> visits, int i, int number) {
        // visits에 값이 contains 한다는 것은 i보다 더 적은 수를 사용하여 number를 만들 수 있다는 뜻 이므로 최적화를 위해 사용
        if (number > 0 && !visits.contains(number)) {
            dp[i].add(number);
            visits.add(number);
        }
    }
}
