import math
import collections


def solution(progresses, speeds):
    remainTime = collections.deque()
    answer = []

    # 배포까지 남은 일 수를 구할 수 있다.
    # 100 - (현재 진행상황) / (속도 per day) = 남은 일 수 => ceil하는 이유는 2.3 일은 3일이 걸리기 때문
    for i, j in zip(progresses, speeds):
        remainTime.append(math.ceil((100 - i) / j))

    print(remainTime)

    cnt = 1
    processingTime = remainTime.popleft()

    while remainTime:
        popleft = remainTime.popleft()

        if popleft > processingTime:
            answer.append(cnt)
            cnt = 1
            processingTime = popleft
            continue
        cnt += 1

    # [1] 이나 , 마지막 처리를 위해
    answer.append(cnt)

    return answer


if __name__ == '__main__':
    print(solution([1, 99, 99], [100, 1, 1]))
