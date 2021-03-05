public class chomily {
    public int solution(String numbers) {
        Set<Integer> combinations = new HashSet<>();
        permutation("", numbers, combinations);

        int answer = 0;
        for (int number : combinations) {
            if (number == 2) {
                answer++;
                continue;
            }
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    public void permutation(String prefix, String number, Set<Integer> combinations) {
        if (!prefix.equals("")) {
            combinations.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < number.length(); i++) {
            permutation(prefix + number.charAt(i), number.substring(0, i) + number.substring(i + 1), combinations);
        }
    }

    public boolean isPrime(int number) {
        if (number == 1 || number ==0 || number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= number / 2; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}