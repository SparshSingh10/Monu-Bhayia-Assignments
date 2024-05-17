import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numOfHouses = scanner.nextInt();
            int[] arr = new int[numOfHouses];
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println(mar(arr));
        }
    }

    private static int mar(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < dp.length; i++) {
            int amountRobbed = money[i] + dp[i - 2];
            int amountNotRobbed = dp[i - 1];
            dp[i] = Math.max(amountRobbed, amountNotRobbed);
        }

        return dp[dp.length - 1];
    }
}
