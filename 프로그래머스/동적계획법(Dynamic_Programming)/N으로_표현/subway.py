def solution(N, number):

    f = [set() for _ in range(10)]
    concatenate = ''

    for count in range(1, 10):
        concatenate += str(N)
        temp = set()
        temp.add(int(concatenate))
        for k in range(1, count):
            for j in f[k]:
                for l in f[count - k]:
                    temp.add(j + l)
                    temp.add(j - l)
                    if l != 0:
                        temp.add(j // l)
                    temp.add(j * l)
        f[count] = temp
        if number in f[count]:
            break
    else:
        return -1

    return count


if __name__ == '__main__':
    print(solution(5, 12))