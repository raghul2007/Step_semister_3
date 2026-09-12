package string.assignment_problems;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(
            double[] playerScores,
            int captainIndex,
            int viceCaptainIndex) {

        playerScores[captainIndex] =
                playerScores[captainIndex] * 2;

        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        double[] scores = {
                40, 55, 30, 62
        };

        int captainIndex = 1;
        int viceCaptainIndex = 3;

        applyMultipliers(
                scores,
                captainIndex,
                viceCaptainIndex
        );

        System.out.println(
                "Updated Scores: " +
                Arrays.toString(scores)
        );
    }
}