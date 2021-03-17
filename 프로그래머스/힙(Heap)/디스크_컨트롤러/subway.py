import heapq


# SRT 스케줄링
# 작업시간이 짧은 것부터 처리하는 스케줄링 알고리즘
def solution(jobs):
    # 짧은 작업순서대로 소팅
    jobs.sort()
    answer = 0
    lastProcessEndTime, candidates = 0, []

    # 마지막 작업이 끝난 lastProcessEndTime 보다 새로 들어오는 작업의 시간이 더 클 경우
    # 우선순위 큐에서 가장 짧은 작업들을 뽑아 마지막 작업순서를 맞춰줌
    # 왜냐하면 디스크가 작업을 수행하고 있지 않을 경우에는 즉시 시작하기 때문에 시간을 맞춰줘야해
    # 큐에 대기중인 작업들이 다 처리된 후에도 새로 들어오는 작업의 시간이 더 클 경우에는 start + delay 로 마지막 작업시간을 맞춰주고
    # 아닐 경우는 다시 큐에 넣어서 현재 작업이 끝날 때까지 큐에서 대기함
    for start, delay in jobs:
        while start >= lastProcessEndTime:
            if candidates:
                d, s = heapq.heappop(candidates)
                answer += lastProcessEndTime - s + d
                lastProcessEndTime += d
            # 큐가 비어버릴 때
            else:
                lastProcessEndTime = start + delay
                answer += delay
                break
        # break 를 타지 않을 때 실행되는 else
        # 큐의 마지막 작업을 다 처리했는데도 새로 들어오는 프로세스의 start가 더 작으면 다시 큐에 넣어서 대기시킴
        # -----|---------------|
        #                   마지막 작업
        #  새로 들어오는 프로세스(start)
        else:
            heapq.heappush(candidates, [delay, start])

    # 모든 작업을 대기 큐에 넣어두고 작업들을 처리하는 로직
    while candidates:
        d, s = heapq.heappop(candidates)
        answer += lastProcessEndTime - s + d
        lastProcessEndTime += d

    return answer // len(jobs)
