import collections


def solution(prices):
    que = collections.deque(prices)
    answer = []

    for i in range(len(prices)):
        popleft = que.popleft()
        cnt = 0
        for j in range(i + 1, len(prices)):
            if popleft <= prices[j]:
                cnt += 1
            else:
                cnt += 1
                break
        answer.append(cnt)

    return answer


if __name__ == '__main__':
    print(solution([1, 1]))
