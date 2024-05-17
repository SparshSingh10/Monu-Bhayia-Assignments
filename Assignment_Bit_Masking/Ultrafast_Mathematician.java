package Assignment_Bit_Masking;

import java.util.*;

public class Ultrafast_Mathematician {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int cs = rubix.nextInt();
        while (cs-- > 0) {
            String st1 = rubix.next();
            String st2 = rubix.next();
            System.out.println(doMaths(st1, st2));
        }
    }

    private static String doMaths(String st1, String st2) {
        StringBuilder sna = new StringBuilder();
        for (int i = 0; i < st1.length(); i++) {
            if (st1.charAt(i) != st2.charAt(i)) {
                sna.append('1');
            } else {
                sna.append('0');
            }
        }
        return sna.toString();
    }
}
