package Assignment_Bit_Masking;

import java.util.Scanner;

public class Popcount_Bits {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        long x = rubix.nextLong();
        long y = rubix.nextLong();
        System.out.println(Count_pop(x, y));
    }

    private static long Count_pop(long x, long y) {
        for (long i = 1; (x | i) <= y; i <<= 1) {
            x = x | i;
        }
        return x;
    }
}
