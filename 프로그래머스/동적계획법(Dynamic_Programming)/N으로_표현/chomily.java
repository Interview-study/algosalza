import java.util.HashSet;
import java.util.Set;

/*
* 동적계획법(Dynamic Programing)
* Probrlem을 SubProblem들로 나눌 수 있고,
* Sub problem들이 중복해서 사용될 때(Memoization) 메모리 영역으로 수행 시간 효율성을 높이는 방법
* ex) 피보나치 수열
* 탑다운과 바텀업 방식이 있음.
* */
public class MakeNumberWithN {
    public int solution(int N, int number) {
        int t = N;
        Set<Integer>[] possibility = new Set[9];

        for (int i = 1; i < 9; i++) {
            possibility[i] = new HashSet<>();
            possibility[i].add(t);
            t = t * 10 + N;
        }

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : possibility[j]) {
                    for (int b : possibility[i - j]) {
                        possibility[i].add(a + b);
                        possibility[i].add(a - b);
                        possibility[i].add(b - a);
                        possibility[i].add(a * b);
                        if (b != 0) possibility[i].add(a / b);
                        if (a != 0) possibility[i].add(b / a);
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            if (possibility[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}