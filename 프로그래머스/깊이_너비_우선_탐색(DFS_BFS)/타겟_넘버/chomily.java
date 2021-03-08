public class TargetNumber {
    public int solution(int[] numbers, int target) {
        List<Integer> results = new ArrayList<>();

        results.add(numbers[0]);
        results.add(-numbers[0]);

        calculate(numbers, 1, results);

        return (int)results
                .stream()
                .filter(it -> it == target)
                .count();
    }

    private void calculate(int[] numbers, int index, List<Integer> results) {
        if (index == numbers.length) {
            return;
        }

        List<Integer> temp = new ArrayList<>(results);
        results.clear();

        for (int number : temp) {
            results.add(number + numbers[index]);
            results.add(number - numbers[index]);
        }

        calculate(numbers, index + 1, results);
    }
}
