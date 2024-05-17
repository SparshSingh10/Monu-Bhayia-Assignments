package Hashing;

import java.util.Scanner;

public class NHAY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            sc.nextInt();
            String pt = sc.next();
            String s = sc.next();
            KMP(pt, s);
        }
    }

    public static void KMP(String p, String t) {
        String s = p + "#" + t;
        int[] dp = new int[s.length()];
        int i = 1;
        int len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                dp[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = dp[len - 1];
                } else {
                    i++;
                }
            }
        }
        for (int j = p.length(); j < dp.length; j++) {
            if (dp[j] == p.length()) {
                System.out.println(j - 2 * p.length());
            }
        }
        System.out.println();
    }
}
