// We are given a hashmap which maps all the letters with number. Given 1 is mapped with A, 2 is mapped with B…..26 is mapped with Z. Given a number, you have to print all the possible strings.

import java.util.*;

public class MappedStrings {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        String num = rubix.next();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) (i + 64) + "");
        }
        strings(num, map, "");
    }

    private static void strings(String num, HashMap<Integer, String> map, String xyz) {
        if (num.length() == 0) {
            System.out.println(xyz);
            return;
        }
        char ch = num.charAt(0);
        String s = map.get(ch - '0');
        strings(num.substring(1), map, xyz + s);
        if (num.length() >= 2) {
            String s1 = num.substring(0, 2);
            int n = Integer.parseInt(s1);
            if (n <= 27) {
                strings(num.substring(2), map, xyz + map.get(n));
            }
        }
    }
}