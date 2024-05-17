package Assignment_Bit_Masking;

import java.util.*;

public class XOR_Result {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int len = rubix.nextInt();
        int start = rubix.nextInt();
        System.out.println(resultXOR(len, start));
    }

    private static int resultXOR(int len, int start) {
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = ans ^ (start + 2 * i);
        }
        return ans;
    }
}
