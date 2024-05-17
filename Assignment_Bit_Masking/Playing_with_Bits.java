// Prateek Bhayia likes to play with bits. One day Prateek bhayia decides to assign a task to his student Sanya.
// You have help Sanya to complete this task. Task is as follows - Prateek Bhayia gives Q queries each query containing two integers a and b.
// Your task is to count the no of set-bits in for all numbers between a and b (both inclusive)

package Assignment_Bit_Masking;

import java.util.*;

public class Playing_with_Bits {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int qy = rubix.nextInt();
        while (qy-- > 0) {
            int si = rubix.nextInt();
            int ei = rubix.nextInt();
            System.out.println(setBits(si, ei));
        }
    }

    private static int setBits(int si, int ei) {
        int ans = 0;
        for (int i = si; i <= ei; i++) {
            int ele = i;
            while (ele > 0) {
                ans++;
                ele = (ele & (ele - 1));
            }
        }
        return ans;
    }

}
