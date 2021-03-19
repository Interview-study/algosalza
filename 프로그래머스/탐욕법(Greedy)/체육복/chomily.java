import java.util.*;

public class SportUniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] people = new int[n];

        for (int lostStudent : lost) {
            people[lostStudent - 1]--;
        }

        for (int reserveStudent : reserve) {
            people[reserveStudent - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i - 1] == 1) {
                    people[i - 1]--;
                    people[i]++;
                } else if (i + 1 < people.length && people[i + 1] == 1) {
                    people[i + 1]--;
                    people[i]++;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int j = 0;
        for (int i = 0; i < lost.length; i++) {
            while (j < reserve.length) {
                if (lost[i] + 1 < reserve[j]) {
                    break;
                }

                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    j++;
                    break;
                }

                if (lost[i] - 1 == reserve[j]) {
                    if (j + 1 < reserve.length && reserve[j + 1] == lost[i]) {
                        lost[i] = 0;
                        j += 2;
                    } else {
                        lost[i] = 0;
                        j++;
                    }
                    break;
                }

                if (lost[i] + 1 == reserve[j]) {
                    if (i + 1 < lost.length && lost[i + 1] == reserve[j]) {
                        break;
                    }
                    lost[i] = 0;
                    j++;
                    break;
                }
                j++;
            }
        }

        return n - (int)Arrays.stream(lost).filter(it -> it != 0).count();
    }
}
