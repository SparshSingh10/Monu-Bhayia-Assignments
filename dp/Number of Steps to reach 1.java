
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(scsacsacas(num, 0));
        // int[] dp = new int[num + 2];
     
    }

   

    private static int scsacsacas(int num, int c) {
        if (num == 1) {
            return c;
        }
        if (num % 2 == 0) {
            return scsacsacas(num / 2, c + 1);
        }
        int op1 = scsacsacas(num + 1, c + 1);
        int op2 = scsacsacas(num - 1, c + 1);
        return Math.min(op1, op2);
    }
}
