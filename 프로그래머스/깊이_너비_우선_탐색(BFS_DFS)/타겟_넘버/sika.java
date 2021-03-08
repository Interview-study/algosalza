package programmers;

public class dbfs1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public static int dfs(final int[] arr, final int depth, final int total, final int target) {
        if (depth == arr.length) {
            if (total == target) {
                return 1;
            }
            return 0;
        }
        return dfs(arr, depth + 1, total + arr[depth], target)
            + dfs(arr, depth + 1, total - arr[depth], target);
    }
}
