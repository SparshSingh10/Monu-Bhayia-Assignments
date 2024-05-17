// You are given a running data stream of n integers. You read all integers from that running data stream and find effective median of elements read so far in efficient way. All rrrra[i]bers are unique in the datastream. Print only the integer part of the median.

import java.util.*;

public class MedianInAStreamOfRunningIntegers {

    private static void median(int[] rra) {
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        pq_max.add(rra[0]);
        System.out.print(rra[0] + " ");
        for (int i = 1; i < rra.length; i++) {
            if (pq_max.size() > pq_min.size()) {
                if (pq_max.peek() > rra[i]) {
                    pq_min.add(pq_max.poll());
                    pq_max.add(rra[i]);
                } else {
                    pq_min.add(rra[i]);
                }
                System.out.print((pq_max.peek() + pq_min.peek()) / 2 + " ");
            } else {
                if (rra[i] <= pq_max.peek()) {
                    pq_max.add(rra[i]);
                } else {
                    pq_min.add(rra[i]);
                    pq_max.add(pq_min.poll());
                }
                System.out.print(pq_max.peek() + " ");
            }

        }
    }

    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int t = rubix.nextInt();
        while (t-- > 0) {
            int size = rubix.nextInt();
            int[] rra = new int[size];
            for (int i = 0; i < rra.length; i++) {
                rra[i] = rubix.nextInt();
            }
            median(rra);
            System.out.println();
        }
    }
}
