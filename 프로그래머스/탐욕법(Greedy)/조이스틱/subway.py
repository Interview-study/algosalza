def solution(name):
    answer = 0
    length = len(name)
    min_move = length - 1
    for i in range(length):
        answer += min(ord(name[i]) - ord('A'), ord('Z') - ord(name[i]) + 1)

        next = i + 1
        while next < length and name[next] == 'A':
            next += 1

        min_move = min(min_move, i + i + length - next)
    answer += min_move
    return answer