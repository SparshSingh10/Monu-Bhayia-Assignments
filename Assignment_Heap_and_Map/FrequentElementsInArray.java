// Given an integer array nums and an integer k, Print the k most frequent elements. You have return the answer in sorted order.

import java.util.*;

public class FrequentElementsInArray {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int size = rubix.nextInt();
        int k = rubix.nextInt();
        int[] rra = new int[size];
        for (int l = 0; l < rra.length; l++) {
            rra[l] = rubix.nextInt();
        }
        kFrequent(rra, k);
    }

    private static void kFrequent(int[] rra, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rra.length; i++) {
            if (map.containsKey(rra[i])) {
                map.put(rra[i], map.get(rra[i]) + 1);
            } else {
                map.put(rra[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // return map.get(o2) - map.get(o1);
                int res = map.get(o2) - map.get(o1);
                if (res == 0) {
                    return o2 - o1;
                }
                return res;
            }
        });
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i));
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}

// import java.util.*;

// public class FrequentElementsInArray {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int k = sc.nextInt();
// HashMap<Integer, Integer> hs = new HashMap<>();
// for (int i = 0; i < n; i++) {
// int item = sc.nextInt();
// hs.put(item, hs.getOrDefault(item, 0) + 1);
// }
// PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
// @Override
// public int compare(Integer o1, Integer o2) {
// int result = hs.get(o1) - hs.get(o2);
// if (result == 0)
// result = o1 - o2;
// return result;
// }
// });
// ArrayList<Integer> keys = new ArrayList<>(hs.keySet());
// for (int i = 0; i < k; i++)
// pq.add(keys.get(i));
// for (int i = k; i < keys.size(); i++) {
// if (hs.get(pq.peek()) <= hs.get(keys.get(i))) {
// pq.poll();
// pq.add(keys.get(i));
// }
// }
// // for(int i:hs.keySet())
// // System.out.println(i+" "+hs.get(i));
// int[] ans = new int[k];
// for (int i = 0; i < k; i++)
// ans[i] = pq.poll();
// Arrays.sort(ans);
// for (int i : ans)
// System.out.print(i + " ");

// }
// }