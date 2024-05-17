
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scscsa = sc.nextInt();
        System.out.println(wtt(scscsa));
    }

    private static long wtt(int scscsa) {
        if (scscsa <= 2) {
            return scscsa;
        }
        long[] dp = new long[scscsa + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[scscsa];
    }
}
