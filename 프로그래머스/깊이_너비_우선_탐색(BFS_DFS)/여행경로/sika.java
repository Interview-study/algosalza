package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class dbfs4 {
    private static final List<String[]> answers = new LinkedList<>();
    private static final String ICN = "ICN";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][] {
            {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
            {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        final List<Ticket> lists = Arrays.stream(tickets)
            .map(it -> new Ticket(it[0], it[1]))
            .sorted()
            .collect(Collectors.toList());

        dfs(lists, ICN, new ArrayList<>());

        return answers.get(0);
    }

    public static void dfs(final List<Ticket> tickets, final String current, final List<String> result) {
        if (tickets.size() == 0) {
            result.add(current);
            answers.add(result.toArray(new String[] {}));
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            final Ticket ticket = tickets.get(i);
            if (ticket.start.equals(current)) {
                final List<Ticket> remained = new LinkedList<>(tickets);
                result.add(current);
                remained.remove(ticket);
                dfs(remained, ticket.end, new ArrayList<>(result));
                result.remove(result.size() - 1);
            }
        }
    }

    private static class Ticket implements Comparable<Ticket> {
        final String start;
        final String end;

        public Ticket(final String start, final String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Ticket that) {
            if (this.start.equals(ICN)) {
                if (that.start.equals(ICN)) {
                    return this.end.compareTo(that.end);
                }
                return -1;
            }
            if (that.start.equals(ICN)) {
                return 1;
            }
            if (this.start.equals(that.start)) {
                return this.end.compareTo(that.end);
            }
            return this.start.compareTo(that.start);
        }
    }
}
