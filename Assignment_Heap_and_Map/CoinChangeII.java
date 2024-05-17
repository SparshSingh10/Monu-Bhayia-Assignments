// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// The answer is guaranteed to fit into a signed 32-bit integer.

package DynamicProgramming;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        System.out.println(change(amount, coins, 0));
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(change2(amount, coins, 0, dp));
        System.out.println(change3(amount, coins));

    }

    private static int change3(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int am = 1; am < dp.length; am++) {
            for (int i = 0; i < dp[0].length; i++) {
                int inc = 0, exc = 0;
                if (am >= coins[i]) {
                    inc = dp[am - coins[i - 1]][i];
                }
                exc = dp[am][i - 1];
                dp[am][i] = inc + exc;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // using dp
    private static int change2(int amount, int[] coins, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (dp[amount][i] != -1) {
            return dp[amount][i];
        }
        int inc = 0;
        int exc = 0;
        if (amount >= coins[i]) {
            inc = change2(amount - coins[i], coins, i, dp);
        }
        exc = change2(amount, coins, i + 1, dp);

        return dp[amount][i] = inc + exc;
    }

    // using recursion
    private static int change(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        int inc = 0;
        int exc = 0;
        if (amount >= coins[i]) {
            inc = change(amount - coins[i], coins, i);
        }
        exc = change(amount, coins, i + 1);

        return inc + exc;
    }

}