package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class hash4 {
    public static void main(String[] args) {
        final String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        final int[] plays = {500, 600, 500, 800, 2500};

        final int[] solution = solution(genres, plays);
        for (final int j : solution) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] solution(String[] genres, int[] plays) {
        final Map<String, Integer> genreTotal = new HashMap<>();
        final List<Song> songs = new ArrayList<>();
        final List<Integer> best = new ArrayList<>();

        for (int i = plays.length - 1; i >= 0; i--) {
            genreTotal.merge(genres[i], plays[i], Integer::sum);
            songs.add(new Song(genres[i], i, plays[i]));
        }
        Collections.sort(songs);
        final List<Map.Entry<String, Integer>> genre = new ArrayList<>(genreTotal.entrySet());
        genre.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (final Map.Entry<String, Integer> e : genre) {
            int count = 0;
            for (final Song song : songs) {
                if (count < 2 && e.getKey().equals(song.genre)) {
                    best.add(song.number);
                    count++;
                }
            }
        }

        final int[] answers = new int[best.size()];
        for (int i = 0; i < best.size(); i++) {
            answers[i] = best.get(i);
        }
        return answers;
    }

    private static class Song implements Comparable<Song> {
        final String genre;
        final int number;
        final int plays;

        public Song(final String genre, final int number, final int plays) {
            this.genre = genre;
            this.number = number;
            this.plays = plays;
        }

        @Override
        public int compareTo(final Song that) {
            if (this.plays > that.plays) {
                return -1;
            } else if (this.plays == that.plays) {
                if (this.number < that.number) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
