import java.util.Scanner;

public class HiddenWord {
    // Instance variable to store the hidden word
    private String hiddenWord;

    // Constructor to initialize the hidden word
    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase(); // Ensure the word is in uppercase
    }

    // Method to generate a hint based on the guess
    public String getHint(String guess) {
        guess = guess.toUpperCase(); // Ensure the guess is in uppercase
        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < hiddenWord.length(); i++) {
            char guessChar = guess.charAt(i);
            if (guessChar == hiddenWord.charAt(i)) {
                hint.append(guessChar); // Matching character in the correct position
            } else if (hiddenWord.contains(String.valueOf(guessChar))) {
                hint.append('+'); // Character is in the hidden word but in a different position
            } else {
                hint.append('*'); // Character is not in the hidden word
            }
        }

        return hint.toString();
    }

    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the hidden word
        System.out.println("Enter a 5-letter word:");
        String word = scanner.nextLine();

        // Create a HiddenWord object
        HiddenWord puzzle = new HiddenWord(word);

        // Start the guessing loop
        System.out.println("Enter Guesses:");
        while (true) {
            String guess = scanner.nextLine();

            // Get the hint for the current guess
            String hint = puzzle.getHint(guess);

            // Print the hint
            System.out.println(hint);

            // Check if the user guessed correctly
            if (hint.equals(word.toUpperCase())) {
                System.out.println("Yes, you got it.");
                break;
            }
        }

        scanner.close();
    }
}
