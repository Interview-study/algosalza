
import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)

    while scoville:
        pop1 = heapq.heappop(scoville)
        if pop1 < K:
            if not scoville:
                return -1
            pop2 = heapq.heappop(scoville)
            heapq.heappush(scoville, pop1 + pop2 * 2)
            answer += 1
        else:
            return answer

    return -1


if __name__ == '__main__':
    print(solution([0],	1))