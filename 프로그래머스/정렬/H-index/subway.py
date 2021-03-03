def solution(citations):
    answer = 0
    sortedCitations = sorted(citations)

    for i in range(len(sortedCitations)):
        h = len(sortedCitations) - i

        if i <= h <= sortedCitations[i] and h > answer:
            answer = h

    return answer


# def solution(citations):
#     citations.sort(reverse=True)
#     answer = max(map(min, enumerate(citations, start=1)))
#     return answer
