import java.util.*;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        result[prices.length - 1] = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int now = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < now) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
}
