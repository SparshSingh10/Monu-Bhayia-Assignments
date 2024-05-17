import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] board = new int[rows][columns];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        System.out.println(mpss(board));
    }

    private static int mpss(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        dp[0][0] = board[0][0];
        
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + board[0][j];
        }
        
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
