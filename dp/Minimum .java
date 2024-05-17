import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int www = sc.nextInt();
        int[] pprr = new int[www];
        for (int i = 0; i < www; i++) {
            pprr[i] = sc.nextInt();
        }

        System.out.println(helper(num, pprr, www));
    }

    public static int helper(int num, int[] pprr, int www) {
        int[] dp = new int[www + 1];

        for (int i = 1; i <= www; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (pprr[j - 1] != -1 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], pprr[j - 1] + dp[i - j]);
                }
            }
        }

        return dp[www] == Integer.MAX_VALUE ? -1 : dp[www];
    }
}
