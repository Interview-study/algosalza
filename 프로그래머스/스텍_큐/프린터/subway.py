import collections
import heapq


def solution(priorities, location):
    deque = collections.deque()
    maxHeap = []
    answer = 0

    for index, value in enumerate(priorities):
        deque.append([index, value])
        heapq.heappush(maxHeap, -value)

    # 우선순위큐에서 가장 높은 우선순위 하나 꺼내
    highPriority = -heapq.heappop(maxHeap)

    while True:
        # 프린터 순서 덱에서 가장 앞에 있는 거 꺼내서 비교 시작
        popleft = deque.popleft()

        # 방금 꺼낸 프린터의 우선순위가 가장 높은건가?
        if highPriority == popleft[1]:
            # 그렇다면 팝 하고 개수 하나 올려
            answer += 1
            # 혹시 방금 팝한게 내가 구하려는 위치인가?
            if location == popleft[0]:
                return answer
            # 아니면 다시 우선순위큐에서 다음 우선순위가 높은거 꺼내(왜냐면 방금 가장 높은거 팝했으니까)
            highPriority = -heapq.heappop(maxHeap)
        # 방금 꺼낸 프린터의 우선순위가 높지 않다면 뒤로 가셈요
        deque.append(popleft)
