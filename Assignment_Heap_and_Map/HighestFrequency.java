// Given an array find the number which comes with maximum frequency. It must work in O(n) time complexity.

import java.util.*;

public class HighestFrequency {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int size = rubix.nextInt();
        int[] rra = new int[size];
        for (int l = 0; l < rra.length; l++) {
            rra[l] = rubix.nextInt();
        }
        System.out.println(maxFreq(rra));
    }

    private static int maxFreq(int[] rra) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rra.length; i++) {
            if (map.containsKey(rra[i])) {
                map.put(rra[i], map.get(rra[i]) + 1);
            } else {
                map.put(rra[i], 1);
            }
        }
        int ans = 0;
        int freq = 0;
        for (int i = 0; i < rra.length; i++) {
            if (map.get(rra[i]) > freq) {
                freq = map.get(rra[i]);
                ans = rra[i];
            }
        }
        return ans;
    }
}
