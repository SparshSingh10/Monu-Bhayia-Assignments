package Assignment_Bit_Masking;

import java.util.Scanner;

public class Max_XOR_Array {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int[] rra = new int[ele];
        for (int x = 0; x < rra.length; x++) {
            rra[x] = rubix.nextInt();
        }
        System.out.println(max_XOR(rra));
    }

    private static int max_XOR(int[] rra) {
        int rox = 0;
        for (int i = 0; i < rra.length; i++) {
            rox = rox ^ rra[i];
        }
        int sna = Integer.MIN_VALUE;
        for (int i = 0; i < rra.length; i++) {
            sna = Math.max(sna, (rox | rra[i]));
        }
        return sna;
    }
}
