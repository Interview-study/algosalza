import collections

adjacencyList = collections.defaultdict(list)
done = False
answer = []


def initialAdjacencyMatrix(tickets):
    for i in tickets:
        start, target = i
        adjacencyList[start].append(target)
    for i in adjacencyList:
        adjacencyList[i] = sorted(adjacencyList[i], reverse=True)


def DFS(start, temp):
    global done
    global answer

    if done:
        return

    if start not in adjacencyList or len(adjacencyList[start]) == 0:
        for i in adjacencyList:
            if len(adjacencyList[i]) != 0:
                break
        else:
            done = True
            temp.append(start)
            # if len(answer) == 0:
            answer = temp
        return

    for i in range(len(adjacencyList[start]) - 1, -1, -1):
        pop = adjacencyList[start].pop(i)
        DFS(pop, temp + [start])
        adjacencyList[start].append(pop)


def solution(tickets):
    initialAdjacencyMatrix(tickets)
    DFS("ICN", [])

    return answer


if __name__ == '__main__':
    print(solution([['ICN', 'AAA'], ['ICN', 'AAA'], ['AAA', 'ICN'], ['AAA', 'CCC']]))
