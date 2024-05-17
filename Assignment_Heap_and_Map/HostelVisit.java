// Dean of MAIT is going to visit Hostels of MAIT. As you know that he is a very busy person so he decided to visit only first "K" nearest Hostels. Hostels are situated in 2D plane. You are given the coordinates of hostels and you have to answer the Rocket distance of Kth nearest hostel from origin ( Dean's place ) .

import java.util.*;

public class HostelVisit {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int t = rubix.nextInt();
        int k = rubix.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (t-- > 0) {
            int qtype = rubix.nextInt();
            if (qtype == 1) {
                long x = rubix.nextInt();
                long y = rubix.nextInt();
                first(k, x, y, pq);
            } else {
                System.out.println(pq.peek());
            }
        }
    }

    private static void first(int k, long x, long y, PriorityQueue<Long> pq) {
        long distance = x * x + y * y;
        pq.add(distance);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}
