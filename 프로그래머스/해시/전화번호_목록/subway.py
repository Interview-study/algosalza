def solution(phone_book):
    answer = True

    for i in range(len(phone_book)):
        for j in range(len(phone_book)):
            if phone_book[i].startswith(phone_book[j]):
                return False

    return answer


if __name__ == '__main__':
    print(solution(["119", "97674223", "1195524421"]))
