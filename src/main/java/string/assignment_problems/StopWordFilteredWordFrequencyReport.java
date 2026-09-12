package string.assignment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(
            String feedback) {

        String cleaned =
                feedback.toLowerCase();

        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        String[] words =
                cleaned.split("\\s+");

        String[] stopWords = {
                "the",
                "was",
                "and",
                "a",
                "is",
                "of",
                "in"
        };

        HashMap<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {

                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {

                frequency.put(
                        word,
                        frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(
                        frequency.entrySet()
                );

        entries.sort(
                (a, b) ->
                        b.getValue()
                         .compareTo(a.getValue())
        );

        for (Map.Entry<String, Integer> entry
                : entries) {

            System.out.println(
                    entry.getKey() +
                    ": " +
                    entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}