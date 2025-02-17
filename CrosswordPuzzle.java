// CrosswordPuzzle class
public class CrosswordPuzzle {
    private String[][] guesses;
    private String[][] solutions;

    // Constructor
    public CrosswordPuzzle(String[][] solutions) {
        this.solutions = solutions;
        this.guesses = new String[solutions.length][solutions[0].length];
    }

    // Method to get the solution for a clue
    public String getSolution(CrosswordClue clue) {
        StringBuilder solution = new StringBuilder();
        int row = clue.getRow();
        int col = clue.getColumn();

        while (row < solutions.length && col < solutions[0].length && solutions[row][col] != null) {
            solution.append(solutions[row][col]);
            if (clue.getDirection().equals("down")) {
                row++;
            } else {
                col++;
            }
        }
        return solution.toString();
    }

    // Method to check if a guessed word fits in the crossword
    public boolean wordFits(String guess, CrosswordClue clue) {
        int row = clue.getRow();
        int col = clue.getColumn();
        for (int i = 0; i < guess.length(); i++) {
            if (row >= guesses.length || col >= guesses[0].length) {
                return false;
            }
            if (guesses[row][col] != null && !guesses[row][col].equals(String.valueOf(guess.charAt(i)))) {
                return false;
            }
            if (clue.getDirection().equals("down")) {
                row++;
            } else {
                col++;
            }
        }
        return true;
    }
}