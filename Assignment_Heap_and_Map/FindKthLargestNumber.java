// Find the kth largest element in an unsorted array.
// Note:It is the kth largest element in the sorted order, not the kth distinct element.

import java.util.*;

public class FindKthLargestNumber {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int size = rubix.nextInt();
        int k = rubix.nextInt();
        int[] rra = new int[size];
        for (int l = 0; l < rra.length; l++) {
            rra[l] = rubix.nextInt();
        }
        System.out.println(kthLargest(rra, k));
    }

    private static int kthLargest(int[] rra, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rra.length; i++) {
            pq.add(rra[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
