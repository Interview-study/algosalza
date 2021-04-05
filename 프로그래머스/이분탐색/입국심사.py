
import sys


def solution(n, times):
    start = 1
    end = times[len(times) - 1] * n
    mid = (start + end) // 2
    sum = 0
    ans = sys.maxsize

    while start <= end:
        for i in times:
            sum += (mid // i)

        if sum < n:
            start = mid + 1
        else:
            ans = min(ans, mid)
            end = mid - 1

        mid = (start + end) // 2
        sum = 0

    return ans


if __name__ == '__main__':
    print(solution(6, [1, 2, 3, 4]))