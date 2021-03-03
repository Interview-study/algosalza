import collections
import operator


def solution(genres, plays):
    answer = []
    hashMap = collections.defaultdict(dict)
    orderedGeners = {g: 0 for g in set(genres)}

    for i in range(len(genres)):
        orderedGeners[genres[i]] += plays[i]
        hashMap[genres[i]][i] = plays[i]

    sortedGenreOrder = sorted(orderedGeners.items(), key=operator.itemgetter(1), reverse=True)

    for i in hashMap:
        hashMap[i] = dict(sorted(hashMap[i].items(), key=lambda x: (x[1], -x[0])))

    for i in sortedGenreOrder:
        if len(hashMap[i[0]]) < 2:
            answer.append(hashMap[i[0]].popitem()[0])
        else:
            answer.append(hashMap[i[0]].popitem()[0])
            answer.append(hashMap[i[0]].popitem()[0])

    return answer


if __name__ == '__main__':
    solution(["classic", "classic", "classic", "pop"], [500, 600, 600, 100])
