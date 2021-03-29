import heapq

rank = []
root = []
visit = []
adj = []


def init(n):
    global rank
    rank = [0] * n
    for i in range(n):
        root.append(i)


def find(x):
    if root[x] == x:
        return x
    else:
        #  "경로 압축(Path Compression)"
        #  find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
        root[x] = find(root[x])
        return root[x]


def union(x, y):
    x = find(x)
    y = find(y)

    # 싸이클 방지
    if x == y:
        return

    if rank[x] < rank[y]:
        root[x] = y
    else:
        root[y] = x
        if rank[x] == rank[y]:
            rank[x] += 1


def solution(n, costs):
    init(n)
    answer = 0
    costs.sort(key=lambda x: x[2])
    for from_, to_, cost in costs:
        if find(from_) != find(to_):
            union(from_, to_)
            answer += cost
    return answer


# 프림알고리즘
# def solution(n, costs):
#     ans = 0
#     adj = [[] for _ in range(n)]
#
#     # 초기화
#     for from_, to_, cost in costs:
#         adj[from_].append([cost, from_, to_])
#         adj[to_].append([cost, to_, from_])
#
#     visit = [False] * n
#     visit[0] = True
#     pq = []
#
#     for i in adj[0]:
#         heapq.heappush(pq, i)
#
#     while pq:
#         cost, from_, to_ = heapq.heappop(pq)
#         if not visit[to_]:
#             visit[to_] = True
#             ans += cost
#             for i in adj[to_]:
#                 if not visit[i[2]]:
#                     heapq.heappush(pq, i)
#
#     return ans


if __name__ == '__main__':
    print(solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]))
