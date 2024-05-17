import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println(filbs(nums));
    }

    private static int filbs(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    int currentLength = dp[j] + 1;
                    dp[i] = Math.max(dp[i], currentLength);
                }
            }
        }

        int maxLength = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
