import java.util.Scanner;

public class CoinGame {
    private int startingCoins; // starting number of coins  
    private int maxRounds; // maximum number of rounds played
    private int player1Coins;
    private int player2Coins;
    
    public CoinGame(int s, int r) {
        startingCoins = s;
        maxRounds = r;
        player1Coins = s;
        player2Coins = s;
    }
    
    /** Returns the number of coins (1, 2, or 3) that player 1 will spend. */
    public int getPlayer1Move() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coins to spend (1, 2, or 3): ");
        int move = scanner.nextInt();
        while (move < 1 || move > 3) {
            System.out.print("Invalid input. Enter 1, 2, or 3: ");
            move = scanner.nextInt();
        }
        return move;
    }
    
    /** Returns the number of coins that player 2 will spend based on the round number. */
    public int getPlayer2Move(int round) {
        if (round % 3 == 0) {
            return 3;
        } else if (round % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    
    /** Plays a simulated game between two players. */
    public void playGame() {
        for (int round = 1; round <= maxRounds; round++) {
            if (player1Coins < 3 || player2Coins < 3) {
                break;
            }
            
            System.out.println("\nRound " + round);
            System.out.println("Player 1 Coins: " + player1Coins);
            System.out.println("Player 2 Coins: " + player2Coins);
            
            int player1Move = getPlayer1Move();
            int player2Move = getPlayer2Move(round);
            
            System.out.println("Player 1 Spends: " + player1Move);
            System.out.println("Player 2 Spends: " + player2Move);
            
            player1Coins -= player1Move;
            player2Coins -= player2Move;
            
            if (player1Move == player2Move) {
                player2Coins += 1;
            } else if (Math.abs(player1Move - player2Move) == 1) {
                player2Coins += 1;
            } else if (Math.abs(player1Move - player2Move) == 2) {
                player1Coins += 2;
            }
        }
        
        System.out.println("\nEnd of Game");
        System.out.println("Player 1 Coins: " + player1Coins);
        System.out.println("Player 2 Coins: " + player2Coins);
        
        if (player1Coins == player2Coins) {
            System.out.println("Tie game");
        } else if (player1Coins > player2Coins) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 wins");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting coins: ");
        int startingCoins = scanner.nextInt();
        System.out.print("Enter max rounds: ");
        int maxRounds = scanner.nextInt();
        
        CoinGame game = new CoinGame(startingCoins, maxRounds);
        game.playGame();
    }
}