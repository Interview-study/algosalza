def solution(brown, yellow):
    answer = []
    allBlock = brown + yellow

    for i in range(1, int(allBlock ** 0.5) + 1):
        if allBlock % i == 0:
            row, col = allBlock // i, i

            if (row - 2) * (col - 2) == yellow and (((row - 2) + col) << 1) == brown:
                answer = [row, col]
                break
    return answer
