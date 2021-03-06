numbersList = []
targetNum = 0


def DFS(index, sum_):
    cnt = 0

    # 상태트리를 그려가면서 +, - 에 따라 상태가 변하게 만듬
    if index == len(numbersList):
        if sum_ == targetNum:
            return 1
    else:
        cnt += DFS(index + 1, sum_ + numbersList[index])
        cnt += DFS(index + 1, sum_ - numbersList[index])

    return cnt


def solution(numbers, target):
    global numbersList
    global targetNum

    numbersList = numbers.copy()
    targetNum = target

    answer = DFS(0, 0)
    return answer
# from itertools import product
#
#
# def solution(numbers, target):
#     l = [(x, -x) for x in numbers]
#     print(list(product((1, 2), (3, 4), (5, 6))))
#     s = list(map(sum, product(*l)))
#     return s.count(target)


if __name__ == '__main__':
    print(solution([1, 1, 1, 1, 1], 3))
