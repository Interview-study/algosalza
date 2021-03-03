def solution(array, commands):
    answer = []
    for command in commands:
        i, j, k = command
        sliceList = sorted(array[i - 1:j])
        answer.append(sliceList[k - 1])
    return answer


if __name__ == '__main__':
    print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))
