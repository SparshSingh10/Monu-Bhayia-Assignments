// Given K sorted linked lists of equal sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

// import java.util.*;

// public class MergeKSortedLists {

//     public static class ListNode {
//         int val;
//         ListNode next;

//         ListNode() {
//         }

//         ListNode(int val) {
//             this.val = val;
//         }

//         ListNode(int val, ListNode next) {
//             this.val = val;
//             this.next = next;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner rubix = new Scanner(System.in);
//         int k = rubix.nextInt();
//         int size = rubix.nextInt();
//         ListNode[] lists = new ListNode[k];
//         for (int i = 0; i < lists.length; i++) {
//             ListNode dummy = new ListNode();
//             ListNode temp = dummy;
//             for (int j = 0; j < size; j++) {
//                 ListNode rv = new ListNode();
//                 rv.val = rubix.nextInt();
//                 dummy.next = rv;
//                 dummy = dummy.next;
//             }
//             lists[i] = temp.next;
//         }
//         ListNode ans = mergeKLists(lists);
//         while (ans != null) {
//             System.out.print(ans.val + " ");
//             ans = ans.next;
//         }
//     }

//     public static ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//             @Override
//             public int compare(ListNode o1, ListNode o2) {
//                 return o1.val - o2.val;
//             }
//         });
//         for (ListNode ll : lists) {
//             if (ll != null) {
//                 pq.add(ll);
//             }
//         }
//         ListNode Dummy = new ListNode();
//         ListNode temp = Dummy;
//         while (!pq.isEmpty()) {
//             ListNode rv = pq.poll();
//             Dummy.next = rv;
//             Dummy = Dummy.next;
//             if (rv.next != null) {
//                 pq.add(rv.next);
//             }
//         }
//         return temp.next;
//     }
// }

import java.util.*;

/**
 * MergeKSortedLists
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int k = rubix.nextInt();
        int n = rubix.nextInt();
        int[] arr = new int[k * n];
        for (int i = 0; i < k * n; i++) {
            arr[i] = rubix.nextInt();
        }

        int[] ans = merge(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] merge(int[] arr) {
        int[] ans = new int[arr.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}