import java.util.*;

/*
* AABBAAAAB인 경우 최소 움직임 5인 것 주의.
* 한 자리를 여러 번 들리는 것도 가능함.
* */
public class JoyStick {
    public int solution(String name) {
        int answer = name.chars()
                .map(it -> Math.min(it - 'A', 'Z' - it + 1))
                .sum();

        int length = name.length();
        int minMove = length-1;

        for(int i = 0;i < length;i++){
            int next = i+1;
            while(next < length && name.charAt(next)=='A'){
                next++;
            }
            minMove = Math.min(minMove,i + length - next + Math.min(i,length - next));
        }

        return answer + minMove;
    }
}