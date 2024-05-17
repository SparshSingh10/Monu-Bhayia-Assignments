
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int num = sc.nextInt();
            System.out.println(uggll(num));
        }
    }

    private static long uggll(int num) {
        long dp[] = new long[num];
        int i2 = 0, i3 = 0, i5 = 0;
        long nxt2 = 2;
        long nxt23 = 3;
        long csacsac = 5;
        dp[0] = 1;

        for (int i = 1; i < num; i++) {
            dp[i] = Math.min(nxt2, Math.min(nxt23, csacsac));
            if (dp[i] == nxt2) {
                i2 = i2 + 1;
                nxt2 = dp[i2] * 2;
            }
            if (dp[i] == nxt23) {
                i3 = i3 + 1;
                nxt23 = dp[i3] * 3;
            }
            if (dp[i] == csacsac) {
                i5 = i5 + 1;
                csacsac = dp[i5] * 5;
            }
        }
        return dp[dp.length - 1];
    }
}
