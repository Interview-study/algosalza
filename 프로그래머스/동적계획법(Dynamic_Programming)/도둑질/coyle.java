package programmers.dp;

public class 도둑질 {
    public int solution(int[] money) {
        Money[] dp = new Money[money.length];
        dp[0] = new Money(money[0], true, false);
        if (money[0] > money[1]) {
            dp[1] = new Money(money[0], true, false);
        } else {
            dp[1] = new Money(money[1], false, false);
        }
        if (dp[1].money >= dp[0].money + money[2]) {
            dp[2] = new Money(dp[1].money, dp[1].existsFirst, false);
        } else {
            dp[2] = new Money(dp[0].money + money[2], dp[0].existsFirst, true);
        }

        for (int i = 3; i < dp.length - 1; i++) {
            if (dp[i - 1].money >= dp[i - 2].money + money[i]) {
                dp[i] = new Money(dp[i - 1].money, dp[i - 1].existsFirst, dp[i - 1].existsThird);
            } else {
                dp[i] = new Money(dp[i - 2].money + money[i], dp[i - 2].existsFirst, dp[i - 2].existsThird);
            }
        }

        int answer = 0;
        if (dp[dp.length - 3].existsFirst) {
            answer = Math.max(dp[dp.length - 2].money, dp[dp.length - 3].money);
            if (dp[dp.length - 3].existsThird) {
                answer = Math.max(answer, dp[dp.length - 3].money + money[dp.length - 1] - money[0]);
            } else {
                answer = Math.max(answer, dp[dp.length - 3].money + money[dp.length - 1] - money[0] + money[1]);
            }
        }

        int max = Math.max(dp[dp.length - 2].money, dp[dp.length - 3].money + money[dp.length - 1]);

        return Math.max(answer, max);
    }

    class Money {
        private int money;
        private boolean existsFirst;
        private boolean existsThird;

        public Money(int money, boolean existsFirst, boolean existsThird) {
            this.money = money;
            this.existsFirst = existsFirst;
            this.existsThird = existsThird;
        }
    }
}
