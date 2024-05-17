import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int length = scanner.nextInt();
            System.out.println(cdb(length));
            // System.out.println(cdbRecursive(length, 0));
        }
    }

    private static long cdbRecursive(int length, int lastBit) {
        if (length == 0) {
            return 1;
        }
        long countOne = cdbRecursive(length - 1, 0);
        long countZero = 0;
        if (lastBit != 1) {
            countZero = cdbRecursive(length - 1, 1);
        }
        return countZero + countOne;
    }

    private static long cdb(int length) {
        long[] dp = new long[length + 3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[length + 2];
    }
}
