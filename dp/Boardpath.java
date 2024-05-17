
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sszzii = scanner.nextInt();
        long dice = scanner.nextInt();
        System.out.println("\n" + countPaths(sszzii, dice, ""));
    }

    private static long countPaths(long sszzii, long dice, String path) {
        if (sszzii == 0) {
            System.out.print(path + " ");
            return 1;
        }
        if (sszzii < 0) {
            return 0;
        }
        long totalPaths = 0;
        for (long i = 1; i <= dice; i++) {
            if (sszzii - i >= 0) {
                totalPaths += countPaths(sszzii - i, dice, path + i);
            }
        }
        return totalPaths;
    }
}
