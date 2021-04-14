def solution(money):
    dEven = [0] * len(money)
    dEven[1] = money[1]
    dEven[2] = max(money[1], money[2])

    dOdd = [0] * len(money)
    dOdd[0] = money[0]
    dOdd[1] = max(money[0], money[1])

    for i in range(3, len(money)):
        dEven[i] = max(dEven[i - 1], dEven[i - 2] + money[i])

    for i in range(2, len(money) - 1):
        dOdd[i] = max(dOdd[i - 1], dOdd[i - 2] + money[i])

    return max(dOdd[len(money) - 2], dEven[len(money) - 1])


# def solution(money):
#     moneyLength = len(money)
#     dEven = [0] * moneyLength
#     dEven[1] = money[1]
#     dEven[2] = max(money[1], money[2])
#
#     dOdd = [0] * moneyLength
#     dOdd[0] = money[0]
#     dOdd[1] = max(money[0], money[1])
#     dOdd[2] = max(dOdd[0] + money[2], dOdd[1])
#
#     for i in range(3, moneyLength - 1):
#         dEven[i] = max(dEven[i - 1], dEven[i - 2] + money[i])
#         dOdd[i] = max(dOdd[i - 1], dOdd[i - 2] + money[i])
#
#     dEven[moneyLength - 1] = max(dEven[moneyLength - 3] + money[moneyLength - 1], dEven[moneyLength - 2])
#
#     return max(dOdd[moneyLength - 2], dEven[moneyLength - 1])


if __name__ == '__main__':
    print(solution([1, 7, 2]))