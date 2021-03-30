def solution(routes):
    answer = 0
    routes.sort()

    duplicatedRouteSize = 1
    i = 0
    while True:
        if i == len(routes):
            if duplicatedRouteSize >= 1:
                answer += 1
            break

        interChange = routes[i][1]
        next_ = i + 1
        while True:
            if next_ < len(routes):
                if routes[next_][0] <= interChange:
                    if routes[next_][1] < interChange:
                        interChange = routes[next_][1]
                    i += 1
                    next_ += 1
                    duplicatedRouteSize += 1
                else:
                    answer += 1
                    duplicatedRouteSize = 1
                    i = next_
                    break
            else:
                i += 1
                break

    return answer