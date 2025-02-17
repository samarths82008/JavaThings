// CrosswordClue class
public class CrosswordClue {
    private int wordNum;
    private String direction;
    private int row;
    private int col;
    private String clue;

    // Constructor
    public CrosswordClue(int wordNum, String direction, int row, int col, String clue) {
        this.wordNum = wordNum;
        this.direction = direction;
        this.row = row;
        this.col = col;
        this.clue = clue;
    }

    // Getters
    public int getWordNum() { return wordNum; }
    public String getDirection() { return direction; }
    public int getRow() { return row; }
    public int getColumn() { return col; }
    public String getClue() { return clue; }
}