import collections


def solution(people, limit):
    answer = 0
    people.sort()
    deque = collections.deque(people)

    while deque:
        if len(deque) == 1:
            answer += 1
            break

        first = deque.popleft()
        last = deque.pop()
        if first + last > limit:
            deque.appendleft(first)
        answer += 1
    return answer

# public static int solution(int[] people, int limit) {
#         ArrayDeque<Integer> deque = new ArrayDeque<>();
#
#         for (int person : people) {
#             deque.add(person);
#         }
#
#         deque = deque.stream()
#                 .sorted((o1, o2) -> Long.compare(o2, o1))
#                 .collect(Collectors.toCollection(ArrayDeque::new));
#
#         int answer = 0;
#
#         while (!deque.isEmpty()) {
#             if (deque.size() == 1) {
#                 answer++;
#                 break;
#             }
#
#             Integer first = deque.pollFirst();
#             Integer last = deque.pollLast();
#
#             if (first + last > limit) {
#                 deque.addLast(last);
#             }
#             answer++;
#         }
#
#         return answer;
#     }