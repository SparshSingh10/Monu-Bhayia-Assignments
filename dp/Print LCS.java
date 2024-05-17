import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        
        int lcs = longestCommonSubsequence(str1, str1.length(), str2, str2.length(), memo);
        int i = str1.length();
        int j = str2.length();
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (memo[i - 1][j] > memo[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        result.reverse();
        System.out.println(result.toString());
    }

    public static int longestCommonSubsequence(String s1, int m, String s2, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = longestCommonSubsequence(s1, m - 1, s2, n - 1, memo) + 1;
        } else {
            return memo[m][n] = Math.max(longestCommonSubsequence(s1, m, s2, n - 1, memo),
                    longestCommonSubsequence(s1, m - 1, s2, n, memo));
        }
    }
}
