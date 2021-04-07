import math


def solution(distance, rocks, n):
    remove_rock = 0

    start = 1
    end = distance
    mid = (start + end) // 2

    rocks.sort()
    rocks.insert(0, 0)
    rocks.append(distance)

    max_ = -math.inf

    runner_i = 0
    runner_j = 1

    while start <= end:
        while True:
            if runner_j != len(rocks):
                if rocks[runner_j] - rocks[runner_i] < mid:
                    if runner_j != len(rocks) - 1:
                        remove_rock += 1

                    if remove_rock > n:
                        break
                    runner_j += 1
                else:
                    runner_i = runner_j
                    runner_j = runner_i + 1
            else:
                break

        if remove_rock <= n:
            if max_ < mid:
                max_ = mid
            start = mid + 1
        else:
            end = mid - 1

        # if remove_rock == n:
        #     if max_ < mid:
        #         max_ = mid

        mid = (start + end) // 2
        remove_rock = 0
        runner_i = 0
        runner_j = 1

    return max_


if __name__ == '__main__':
    print(solution(27, [2, 11, 15, 19, 23], 2))