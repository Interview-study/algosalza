import math

numberHash = dict()
duplicated = dict()
N = 0
answer = 0


def determine(n):
    if n == 1 or n == 0:
        return False

    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


def DFS(index, combination):
    global answer
    global N

    if index == N:
        if combination == "":
            return

        combination = int(combination)
        if determine(combination):
            if combination in duplicated:
                return

            duplicated[combination] = 1
            answer += 1
        return

    for i in numberHash:
        if numberHash[i] != 0:
            numberHash[i] -= 1
            DFS(index + 1, combination + i)
            numberHash[i] += 1
            DFS(index + 1, combination)

    return 0


def solution(numbers):
    global numberHash
    global N

    N = len(numbers)
    for i in numbers:
        if i not in numberHash:
            numberHash[i] = 0
        numberHash[i] += 1

    DFS(0, "")

    return answer
