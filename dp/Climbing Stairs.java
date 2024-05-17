
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        int numberOfStairs = scanner.nextInt();
        System.out.println(countWaysToClimbStairs(numberOfStairs));
    }

    private static int countWaysToClimbStairs(int numberOfStairs) {
        if (numberOfStairs == 0) {
            return 0;
        }
        int[] waysToClimb = new int[numberOfStairs + 1];
        waysToClimb[0] = 1;
        waysToClimb[1] = 1;
        for (int i = 2; i <= numberOfStairs; i++) {
            waysToClimb[i] = waysToClimb[i - 1] + waysToClimb[i - 2];
        }

        return waysToClimb[numberOfStairs];
    }
}
