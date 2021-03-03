import itertools


def solution(clothes):
    hash_map = dict()
    answer = 1

    for i in clothes:
        if i[1] not in hash_map:
            hash_map[i[1]] = 1
            continue
        hash_map[i[1]] += 1

    for i in hash_map:
        answer *= hash_map[i] + 1

    return answer - 1


if __name__ == '__main__':
    print(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]))
