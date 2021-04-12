def solution(triangle):
    answer = 0
    if len(triangle) == 1:
        return triangle[0][0]

    d = [triangle[0]]
    for i in range(1, len(triangle)):
        temp = []
        for j in range(len(triangle[i])):
            if j == 0:
                temp.append(triangle[i][j] + d[i - 1][0])
            elif j == len(triangle[i]) - 1:
                temp.append(triangle[i][j] + d[i - 1][len(d[i - 1]) - 1])
            else:
                temp.append(triangle[i][j] + max(d[i - 1][j-1], d[i - 1][j]))

        d.append(temp)
    for value in d[-1]:
        answer = max(answer, value)

    return answer