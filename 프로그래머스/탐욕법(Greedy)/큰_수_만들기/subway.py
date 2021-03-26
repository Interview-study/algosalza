def solution(number, k):
    n = len(number) - k
    start = 0
    index = 0

    answer = ''
    while True:
        maxNum = '-1'
        size = len(answer)
        if size == n:
            break

        findUnit = len(number[start:]) - (n - size) + 1

        for i in range(start, start + findUnit):
            if number[i] == '9':
                index = i
                break
            if maxNum < number[i]:
                maxNum = number[i]
                index = i
        answer += number[index]
        start = index + 1

    return answer


if __name__ == '__main__':
    print(solution("1001", 1))