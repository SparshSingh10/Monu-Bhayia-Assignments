// Given K sorted arrays each with N elements merge them and output the sorted array

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int k = rubix.nextInt();
        int n = rubix.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rubix.nextInt();
            }
        }
        int[] ans = mergeKSorted(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] mergeKSorted(int[][] arr) {
        int[] ans = new int[arr.length * arr[0].length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
