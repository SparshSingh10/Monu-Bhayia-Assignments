package Assignment_Bit_Masking;

import java.util.Scanner;

public class Unique_Number_III {
    public static void main(String args[]) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int rra[] = new int[ele];
        for (int x = 0; x < rra.length; x++) {
            rra[x] = rubix.nextInt();
        }
        int n = rra.length;
        System.out.println(getUnique(rra, n));
        rubix.close();
    }

    public static int getUnique(int rra[], int n) {
        int single = 0;
        int twice = 0;
        int bitMask;
        for (int i = 0; i < n; i++) {
            twice = twice | (single & rra[i]);
            single = single ^ rra[i];
            bitMask = ~(single & twice);
            single = single & bitMask;
            twice = twice & bitMask;
        }
        return single;
    }

}