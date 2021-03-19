import heapq


# def solution(operations):
#     minPriority = []
#     maxPriority = []
#
#     for op in operations:
#         cmd, arg = op.split()
#         if cmd == "I":
#             heapq.heappush(minPriority, int(arg))
#             heapq.heappush(maxPriority, -int(arg))
#         if cmd == "D":
#             if not minPriority:
#                 continue
#
#             if arg == "1":
#                 temp = []
#                 for i in range(len(minPriority)):
#                     heapq.heappush(temp, -minPriority[i])
#                 heapq.heappop(temp)
#
#                 minPriority.clear()
#                 for i in temp:
#                     heapq.heappush(minPriority, -i)
#             if arg == "-1":
#                 heapq.heappop(minPriority)
#
#     if not minPriority:
#         return [0, 0]
#     else:
#         if len(minPriority) == 1:
#             n = heapq.heappop(minPriority)
#             return [n, n]
#         else:
#             n = heapq.heappop(minPriority)
#             temp = []
#             for i in range(len(minPriority)):
#                 heapq.heappush(temp, -minPriority[i])
#             m = -heapq.heappop(temp)
#             return [m, n]


def solution(operations):
    minPriority = []
    maxPriority = []

    for op in operations:
        cmd, arg = op.split()
        if cmd == "I":
            heapq.heappush(minPriority, int(arg))
            heapq.heappush(maxPriority, -int(arg))
        if cmd == "D":
            if not minPriority:
                continue

            if arg == "1":
                maxValue = -heapq.heappop(maxPriority)
                index = minPriority.index(maxValue)
                minPriority.pop(index)
            if arg == "-1":
                minValue = -heapq.heappop(minPriority)
                index = maxPriority.index(minValue)
                maxPriority.pop(index)

    if not minPriority:
        return [0, 0]
    else:
        if len(minPriority) == 1:
            n = heapq.heappop(minPriority)
            return [n, n]
        else:
            m = -heapq.heappop(maxPriority)
            n = heapq.heappop(minPriority)
            return [m, n]


if __name__ == '__main__':
    print(solution(["I 2", "I 4", "D -1", "I 1", "D 1"]))
