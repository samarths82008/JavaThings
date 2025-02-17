public class Magic {
    // Method to generate an odd-sized magic square
    public static int[][] generateMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];

        int row = 0;
        int col = size / 2; // Start in the middle of the first row

        for (int num = 1; num <= size * size; num++) {
            magicSquare[row][col] = num; // Place the number

            int newRow = (row - 1 + size) % size; // Move one row up (wrap around)
            int newCol = (col + 1) % size; // Move one column to the right (wrap around)

            if (magicSquare[newRow][newCol] != 0) { // If the spot is already filled
                row = (row + 1) % size; // Move one row down instead
            } else {
                row = newRow;
                col = newCol;
            }
        }
        return magicSquare;
    }

    // Method to print the magic square
    public static void printMagicSquare(int[][] magicSquare) {
        for (int[] row : magicSquare) {
            for (int num : row) {
                System.out.printf("%4d", num); // Format spacing
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size1 = 5;
        int size2 = 11;

        System.out.println("Magic Square of size " + size1 + ":");
        printMagicSquare(generateMagicSquare(size1));

        System.out.println("Magic Square of size " + size2 + ":");
        printMagicSquare(generateMagicSquare(size2));
    }
}
