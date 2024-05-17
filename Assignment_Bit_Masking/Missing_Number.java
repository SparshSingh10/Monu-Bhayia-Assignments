package Assignment_Bit_Masking;

import java.util.Scanner;

public class Missing_Number {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int[] rra = new int[ele];
        for (int i = 0; i < rra.length; i++) {
            rra[i] = rubix.nextInt();
        }
        System.out.println(findMissingNumber(rra));
    }

    private static int findMissingNumber(int[] rra) {
        int a = 0, b = 0;
        for (int i = 0; i < rra.length; i++) {
            b = b ^ rra[i];
        }
        for (int i = 0; i < rra.length + 1; i++) {
            a = a ^ i;
        }

        return a ^ b;
    }
}
