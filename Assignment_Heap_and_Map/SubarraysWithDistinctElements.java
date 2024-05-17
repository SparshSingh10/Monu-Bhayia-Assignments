// Given an array, the task is to calculate the sum of lengths of contiguous subarrays having all elements distinct

import java.util.*;

public class SubarraysWithDistinctElements {

    public static void main(String args[]) {
        Scanner rubix = new Scanner(System.in);
        int n = rubix.nextInt();
        int[] rra = new int[n];
        for (int i = 0; i < rra.length; i++) {
            rra[i] = rubix.nextInt();
        }
        System.out.println(subarrays(rra));
    }

    public static int subarrays(int[] rra) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < rra.length; i++) {
            while (j < rra.length && !set.contains(rra[j])) {
                set.add(rra[j]);
                j++;
            }
            ans += ((j - i + 1) * (j - i)) / 2;
            set.remove(rra[i]);
        }

        return ans;
    }
}
