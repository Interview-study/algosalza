
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]


def solution(arrows):
    answer = 0
    visit = dict()
    edgeVisit = dict()

    col, row = 0, 0
    visit[(col, row)] = True
    print(visit[(col, row)])

    for arrow in arrows:
        for j in range(2):
            ncol = col + dx[arrow]
            nrow = row + dy[arrow]

            if (ncol, nrow) in visit and ((col, row), (ncol, nrow)) not in edgeVisit:
                edgeVisit[((col, row), (ncol, nrow))] = True
                edgeVisit[((ncol, nrow), (col, row))] = True

                answer += 1
                col = ncol
                row = nrow
                continue

            visit[(ncol, nrow)] = True
            edgeVisit[((col, row), (ncol, nrow))] = True
            edgeVisit[((ncol, nrow), (col, row))] = True
            col = ncol
            row = nrow

    return answer


if __name__ == '__main__':
    print(solution([5, 2, 7, 1, 6, 3]))
