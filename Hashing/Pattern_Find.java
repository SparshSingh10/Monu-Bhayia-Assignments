package Hashing;

import java.util.*;

public class Pattern_Find {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            String p = sc.next();
            Pattern(s, p);
        }
    }

    public static void Pattern(String s, String p) {
        long mod = 1000_000_007;
        long pow = 1;
        long pr = 31;
        long hv = 0;
        for (int i = 0; i < p.length(); i++) {
            int pos = p.charAt(i) - 'a' + 1;
            hv = ((hv + (pos * pow)) % mod) % mod;
            pow = (pow * pr) % mod;
        }

        long[] dp = new long[s.length()];
        long[] pa = new long[s.length()];
        dp[0] = s.charAt(0) - 'a' + 1;
        pa[0] = 1;
        pow = 31;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = (dp[i - 1] + ((s.charAt(i) - 'a' + 1) * pow) % mod) % mod;
            pa[i] = pow;
            pow = (pow * pr) % mod;
        }

        List<Integer> ll = new ArrayList<>();
        int si = 0;
        int ei = p.length() - 1;
        while (ei < s.length()) {
            long curr = dp[ei];
            if (si > 0) {
                curr = curr - dp[si - 1];
                curr = (curr + mod) % mod;
            }

            if (curr == ((hv * pa[si]) % mod)) {
                ll.add(si + 1);
            }

            ei++;
            si++;
        }

        if (ll.size() == 0) {
            System.out.println("Not Found");
        } else {
            System.out.println(ll.size());
            for (int i : ll) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
