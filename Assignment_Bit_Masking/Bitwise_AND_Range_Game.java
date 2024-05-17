package Assignment_Bit_Masking;

import java.util.Scanner;

public class Bitwise_AND_Range_Game {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        long lf = rubix.nextLong();
        long rt = rubix.nextLong();
        System.out.println(AND_RANGE(lf, rt));
    }

    private static long AND_RANGE(long lf, long rt) {
        long sna = 0;
        while (lf != rt && lf > 0) {
            sna++;
            lf = lf >> 1;
            rt = rt >> 1;
        }
        return (long) (1 << sna);
    }
}
