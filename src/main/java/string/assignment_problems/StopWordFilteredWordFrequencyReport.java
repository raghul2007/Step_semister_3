package main.java.string.assignment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        String cleaned = feedback.toLowerCase();

        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        String[] words = cleaned.trim().split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}