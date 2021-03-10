import collections

adjacencyList = []
visit = []
preNode = []
cnt = 0


def initialAdjacencyMatrix(begin, words):
    if begin not in words:
        words.append(begin)

    for i in words:
        adjacencyListOfWord = []
        for j in words:
            if i != j:
                # 키 값이 몇개인지 세줌
                count = collections.Counter(i) - collections.Counter(j)
                if len(count) == 1:
                    adjacencyListOfWord.append(words.index(j))
        adjacencyList.append(adjacencyListOfWord)


def BFS(begin, target, words):
    global cnt

    queue = collections.deque()
    beginIndex = words.index(begin)

    queue.append(beginIndex)
    visit[beginIndex] = 1
    preNode[beginIndex] = -1

    while queue:
        wordIndex = queue.popleft()

        if target == words[wordIndex]:
            # 이전 노드 찾아가면서 시작이 오면 종료
            while True:
                if preNode[wordIndex] != -1:
                    wordIndex = preNode[wordIndex]
                    cnt += 1
                else:
                    return cnt

        for i in adjacencyList[wordIndex]:
            if visit[i] != 1:
                visit[i] = 1
                preNode[i] = wordIndex
                queue.append(i)

    return cnt


def solution(begin, target, words):
    global visit
    global preNode

    if target not in words:
        return 0

    # 인접행렬 초기화
    initialAdjacencyMatrix(begin, words)
    # 방문 체크
    visit = [0] * len(words)
    # BFS 실행 시 부모노드 저장 ex) 1 -> 3 preNode[3] = 1
    preNode = [0] * len(words)

    answer = BFS(begin, target, words)

    return answer


if __name__ == '__main__':
    print(solution("hod", "dog", ["hot", "dog", "dod"]))

# def get_adjacent(current, words):
#     for word in words:
#         if len(current) != len(word):
#             continue
#
#         count = 0
#         for c, w in zip(current, word):
#             if c != w:
#                 count += 1
#
#         if count == 1:
#             yield word
