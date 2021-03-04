public class MockExam {
    public int[] solution(int[] answers) {
        Student student1 = new Student(1, new int[]{1, 2, 3, 4, 5});
        Student student2 = new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Student student3 = new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            student1.grade(i, answer);
            student2.grade(i, answer);
            student3.grade(i, answer);
        }

        int maxScore = Math.max(student1.getScore(), Math.max(student2.getScore(), student3.getScore()));

        return Arrays.asList(student1, student2, student3)
                .stream()
                .filter(it -> it.isWin(maxScore))
                .mapToInt(Student::getNumber)
                .sorted()
                .toArray();
    }
}

class Student {
    private final int number;
    private final int[] pattern;
    private int score;

    public Student(int number, int[] pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    public void grade(int idx, int answer) {
        if (checkAnswer(idx, answer)) {
            this.score++;
        }
    }

    private boolean checkAnswer(int idx, int answer) {
        return pattern[idx % this.pattern.length] == answer;
    }

    public boolean isWin(int maxScore) {
        return this.score == maxScore;
    }

    public int getNumber() {
        return this.number;
    }

    public int getScore() {
        return this.score;
    }
}