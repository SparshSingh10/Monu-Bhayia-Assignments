package Assignment_Bit_Masking;

import java.util.Scanner;

public class Unique_Number_II {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int[] rra = new int[ele];
        for (int x = 0; x < rra.length; x++) {
            rra[x] = rubix.nextInt();
        }

        findUnique(rra);
    }

    private static void findUnique(int[] rra) {
        int ans = rra[0];
        for (int x = 1; x < rra.length; x++) {
            ans = ans ^ rra[x];
        }
        ans = (ans & -ans);
        int a = 0;
        int b = 0;
        for (int i = 0; i < rra.length; i++) {
            if ((rra[i] & ans) > 0) {
                a = (a ^ rra[i]);
            } else {
                b = (b ^ rra[i]);
            }
        }
        if (a < b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
}
