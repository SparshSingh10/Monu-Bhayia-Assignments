package Assignment_Bit_Masking;

import java.util.Scanner;

public class Henry_wants_binary_systems {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        for (int x = 0; x <= ele; x++) {
            System.out.print(setBits(x) + " ");
        }
    }

    private static int setBits(int x) {
        int sna = 0;
        while (x > 0) {
            sna++;
            x = (x & (x - 1));
        }
        return sna;
    }
}
