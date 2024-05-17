package Assignment_Bit_Masking;

import java.util.Scanner;

public class Maximum_XOR_Subarray {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int[] rra = new int[ele];
        for (int x = 0; x < rra.length; x++) {
            rra[x] = rubix.nextInt();
        }
        System.out.println(max_Subarray_XOR(rra));

    }

    private static int max_Subarray_XOR(int[] rra) {
        int sna = Integer.MIN_VALUE;
        for (int i = 0; i < rra.length; i++) {
            int xor = 0;
            for (int j = i; j < rra.length; j++) {
                xor = xor ^ rra[j];
                sna = Math.max(sna, xor);
            }
        }
        return sna;
    }

}
