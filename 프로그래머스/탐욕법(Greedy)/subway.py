def solution(n, lost, reserve):
    answer = 0
    visit = [1] * n

    for i in range(len(lost)):
        visit[lost[i] - 1] = 0

    for i in range(len(lost)):
        if lost[i] in reserve:
            visit[lost[i] - 1] = 1
            reserve[reserve.index(lost[i])] = 0
            lost[i] = 0
    for i in range(len(reserve)):
        if reserve[i] != 0:
            if reserve[i] - 1 in lost:
                lost[lost.index(reserve[i] - 1)] = 0
                visit[reserve[i] - 2] = 1
                continue
            if reserve[i] + 1 in lost:
                visit[reserve[i]] = 1
                lost[lost.index(reserve[i] + 1)] = 0

    for i in visit:
        if i == 1:
            answer += 1

    return answer