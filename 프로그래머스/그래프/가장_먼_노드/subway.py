import collections

adjacencyList = collections.defaultdict(list)


def initAdj(edge):
    for start, end in edge:
        adjacencyList[start].append(end)
        adjacencyList[end].append(start)


def solution(n, edge):
    answer = 0
    visit = [0] * (n + 1)
    initAdj(edge)

    queue = collections.deque()
    queue.append(1)
    visit[1] = 1
    deepDepth = -2147000000

    while queue:
        present = queue.popleft()
        for i in adjacencyList[present]:
            if visit[i] == 0:
                queue.append(i)
                visit[i] = visit[present] + 1
                # if visit[i] > deepDepth:
                #     deepDepth = visit[i]

    # for depth in visit:
    #     if deepDepth == depth:
    #         answer += 1
    # visit.count(deepDepth)
    visit.sort(reverse=True)

    return visit.count(visit[0])