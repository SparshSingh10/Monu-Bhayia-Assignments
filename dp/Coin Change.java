import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int numOfCoins = scanner.nextInt();
        int[] coinDenominations = new int[numOfCoins];
        for (int i = 0; i < numOfCoins; i++) {
            coinDenominations[i] = scanner.nextInt();
        }

        System.out.println(makeChangeWays(amount, coinDenominations));
    }

    private static long makeChangeWays(int amount, int[] coins) {
        long[][] dp = new long[amount + 1][coins.length + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int am = 1; am < dp.length; am++) {
            for (int i = 1; i < dp[0].length; i++) {
                long include = 0, exclude = 0;
                if (am >= coins[i - 1]) {
                    include = dp[am - coins[i - 1]][i];
                }
                exclude = dp[am][i - 1];
                dp[am][i] = include + exclude;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
