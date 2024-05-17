// count number of 1s in binary representation of an integer

package Assignment_Bit_Masking;

import java.util.*;

public class Count_Set_Bits {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int cs = rubix.nextInt();
        while (cs-- > 0) {
            int ele = rubix.nextInt();
            System.out.println(setBits(ele));
        }
    }

    private static int setBits(int ele) {
        int sna = 0;
        while (ele > 0) {
            sna++;
            ele = (ele & (ele - 1));
        }
        return sna;
    }
}
