import collections

a, b, c = 10000, 1, [1, 1, 1, 1, 1, 1, 1, 1]


def solution(bridge_length, weight, truck_weights):
    answer = 0
    index = 0
    sum = 0
    que = []

    while True:
        # print(que, answer)
        if index == len(truck_weights):
            answer += bridge_length
            break

        if len(que) == bridge_length:
            sum -= que.pop(0)
        if sum + truck_weights[index] > weight:
            answer += (bridge_length - len(que))
            que += [0] * (bridge_length - len(que))
        else:
            sum += truck_weights[index]
            que.append(truck_weights[index])
            index += 1
            answer += 1

    return answer





if __name__ == '__main__':
    print(solution(a, b, c))
