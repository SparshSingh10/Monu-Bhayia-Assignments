
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prrcc = sc.nextInt();
        int[] prrccs = new int[prrcc];
        for (int i = 0; i < prrccs.length; i++) {
            prrccs[i] = sc.nextInt();
        }
        int rod = sc.nextInt();
        System.out.println(mpp(prrccs, rod));
    }

    private static int mpp(int[] prrccs, int rod) {
        int[] dp = new int[rod + 1];
        if (rod <= 0) {
            return 0;
        }
        int mcvv = Integer.MIN_VALUE;
        for (int i = 1; i <= rod; i++) {
            for (int j = 0; j < i; j++) {
                mcvv = Math.max(mcvv, prrccs[j] + dp[i - j - 1]);
            }
            dp[i] = mcvv;
        }
        return dp[rod];
    }
}
