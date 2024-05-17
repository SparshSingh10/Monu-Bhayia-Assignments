package Assignment_Bit_Masking;

import java.util.Scanner;

public class Incredible_Hulk {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int cs = rubix.nextInt();
        while (cs-- > 0) {
            int t = rubix.nextInt();
            System.out.println(minSteps(t));
        }
    }

    private static int minSteps(int t) {
        int sna = 0;
        while (t > 0) {
            sna++;
            t = (t & (t - 1));
        }
        return sna;
    }
}
