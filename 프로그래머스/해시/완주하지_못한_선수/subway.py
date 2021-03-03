def solution(participant, completion):
    hash_participant = dict()

    for i in participant:
        if i not in hash_participant:
            hash_participant[i] = 0
        hash_participant[i] += 1

    for i in completion:
        hash_participant[i] -= 1
        if hash_participant[i] == 0:
            hash_participant.pop(i)

    return list(hash_participant.keys())[0]


if __name__ == '__main__':
    print(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]))
