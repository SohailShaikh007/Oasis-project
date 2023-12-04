import java.util.Random;
import java.util.Scanner;

public class GTN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalRounds = 3;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("You have " + totalRounds + " rounds. Each round, you can make up to " + maxAttempts + " attempts.");

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int userGuess;
            int attempts = 0;

            System.out.println("\nRound " + round + ": I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

            do {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += calculateScore(attempts);
                }

                if (attempts == maxAttempts && userGuess != randomNumber) {
                    System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + randomNumber);
                }
            } while (userGuess != randomNumber && attempts < maxAttempts);
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }

    private static int calculateScore(int attempts) {
        // You can customize the scoring logic based on your preferences.
        // For example, you can give more points for fewer attempts.
        return 100 - (attempts - 1) * 10;
    }
}
