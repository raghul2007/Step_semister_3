package string.class_problems;

import java.util.Scanner;

abstract class Question {

    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQQuestion extends Question {

    public MCQQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends Question {

    public TFQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        String[] keywords =
                correctAnswer.split(",");

        int count = 0;

        String answer =
                studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            if (answer.contains(
                    keyword.trim().toLowerCase())) {

                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        }

        if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts =
                    line.split("\"");

            String type =
                    parts[0].trim();

            String correct =
                    parts[2].trim();

            String student =
                    parts[4].trim();

            String remaining =
                    parts[5].trim();

            double points =
                    Double.parseDouble(remaining);

            Question question;

            if (type.equals("MCQ")) {

                question =
                    new MCQQuestion(
                        correct,
                        student,
                        points
                    );

            } else if (type.equals("TF")) {

                question =
                    new TFQuestion(
                        correct,
                        student,
                        points
                    );

            } else {

                question =
                    new EssayQuestion(
                        correct,
                        student,
                        points
                    );
            }

            double score =
                    question.calculateScore();

            System.out.printf(
                "%s: %.2f%n",
                type,
                score
            );

            total += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            total
        );

        sc.close();
    }
}