// We are given an array containg n numbers. All the numbers are present twice except for one number which is only present once.
// Find the unique number without taking any extra spaces and in linear time. ( Hint - Use Bitwise )

package Assignment_Bit_Masking;

import java.util.Scanner;

public class Unique_Number_I {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int ele = rubix.nextInt();
        int[] rra = new int[ele];
        for (int x = 0; x < rra.length; x++) {
            rra[x] = rubix.nextInt();
        }

        System.out.println(findUnique(rra));
    }

    private static int findUnique(int[] rra) {
        int ans = rra[0];
        for (int x = 1; x < rra.length; x++) {
            ans = ans ^ rra[x];
        }
        return ans;
    }
}
