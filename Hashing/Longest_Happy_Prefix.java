package Hashing;

public class Longest_Happy_Prefix {
    public static void main(String[] args) {
        String s = "acccbaaacccbaac";
        System.out.println(longestPrefix(s));
    }

    public static String longestPrefix(String s) {
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
        return s.substring(0, dp[dp.length - 1]);
    }
}
