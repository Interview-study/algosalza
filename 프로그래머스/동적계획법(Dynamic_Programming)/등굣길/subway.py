matrix = []


def initMatrix(m, n, puddle):
    global matrix

    matrix = [[-1] * m for _ in range(n)]

    for row, col in puddle:
        if matrix[col - 1][row - 1] == 0:
            continue

        if row == 1:
            for k in range(col, n):
                matrix[k - 1][0] = 0
            continue
        if col == 1:
            matrix[0][row - 1:] = [0] * (len(matrix[0]) - row + 1)

        matrix[col - 1][row - 1] = 0


def search(m, n):
    matrix[0][0] = 1

    for col in range(n):
        for row in range(m):
            if col == 0 and row == 0:
                continue
            if matrix[col][row] == 0:
                continue

            if col == 0:
                matrix[col][row] = matrix[col][row - 1]
                continue
            if row == 0:
                matrix[col][row] = matrix[col - 1][row]
                continue

            matrix[col][row] = matrix[col - 1][row] + matrix[col][row - 1]


def solution(m, n, puddles):
    initMatrix(m, n, puddles)
    search(m, n)
    for i in matrix:
        print(i)

    return matrix[n - 1][m - 1] % 1000000007


if __name__ == '__main__':
    print(solution(4, 4, [[1, 3]]))
