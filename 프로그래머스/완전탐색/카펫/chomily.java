public class chomily {
    public int[] solution(int brown, int yellow) {
        for(int y = 1; y <= Math.sqrt(yellow); y++) {
            double x = yellow * 1.0 / y;
            if(2 * (x + y + 2) == brown) {
                return new int[]{(int)x + 2, y + 2};
            }
        }
        throw new IllegalStateException();
    }
}
