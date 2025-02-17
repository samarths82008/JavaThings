// CrosswordRunner class for testing
public class CrosswordRunner {
    public static void main(String[] args) {
        // Sample crossword grid
        String[][] solutions = {
            {null, null, null, null, null, null, null},
            {null, null, "T", null, null, null, null},
            {null, "C", "H", "A", "I", "R", "S"},
            {null, null, "R", null, null, null, null},
            {null, null, "E", "A", "T", null, null},
            {null, null, "E", null, "O", null, null},
            {null, null, null, null, "E", null, null}
        };

        CrosswordPuzzle puzzle = new CrosswordPuzzle(solutions);
        CrosswordClue clue1 = new CrosswordClue(1, "down", 1, 2, "single digit number");
        CrosswordClue clue2 = new CrosswordClue(2, "across", 2, 1, "we sit on");

        // Testing getSolution
        System.out.println("Solution for clue1: " + puzzle.getSolution(clue1)); // Expected: THREE
        System.out.println("Solution for clue2: " + puzzle.getSolution(clue2)); // Expected: CHAIRS
    }
}