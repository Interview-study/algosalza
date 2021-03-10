num = 0
adjMatrix = []
visit = []


def DFS(vertex):
    for j in range(num):
        if visit[j] == 0 and adjMatrix[vertex][j] == 1:
            visit[vertex] = 1
            DFS(j)


def solution(n, computers):
    global visit
    global num
    global adjMatrix
    answer = 0

    num = n
    visit = [0] * n
    adjMatrix = computers

# 노드들을 돌면서 탐색한 곳이면 +1 하지 않음
    for vertex in range(n):
        if visit[vertex] == 0:
            DFS(vertex)
            answer += 1

    return answer


if __name__ == '__main__':
    print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
