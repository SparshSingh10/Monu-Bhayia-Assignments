// Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the rra_top (according to their decreasing map_frequency) every time rra new number is read. We basically need to print rra_top k numbers sorted by map_frequency when input stream has included k distinct elements, else need to print all distinct elements sorted by map_frequency. If map_frequency of two numbers are same then print them in increasing order.

import java.util.*;

public class TopKMostFrequentNumberInAStream {
    public static void main(String args[]) {
        Scanner rubix = new Scanner(System.in);
        int test = rubix.nextInt();
        while (test-- > 0) {
            int num = rubix.nextInt();
            int col = rubix.nextInt();
            int[] rra = new int[num];
            for (int l = 0; l < rra.length; l++) {
                rra[l] = rubix.nextInt();
            }
            topKthFreq(rra, num, col);
        }
    }

    private static int indexSearch(int[] rra, int ele) {
        for (int l = 0; l < rra.length; l++) {
            if (rra[l] == ele) {
                return l;
            }
        }
        return -1;
    }

    private static void topKthFreq(int[] rra, int n, int k) {
        int[] rra_top = new int[k + 1];
        HashMap<Integer, Integer> map_freq = new HashMap<>();
        for (int i = 0; i < k + 1; i++) {
            map_freq.put(i, 0);
        }
        for (int l = 0; l < n; l++) {
            if (map_freq.containsKey(rra[l])) {
                map_freq.put(rra[l], map_freq.get(rra[l]) + 1);
            } else {
                map_freq.put(rra[l], 1);
            }
            rra_top[k] = rra[l];
            int i = indexSearch(rra_top, rra[l]);
            i -= 1;
            while (i >= 0) {
                if (map_freq.get(rra_top[i]) < map_freq.get(rra_top[i + 1])) {
                    swap(rra_top, i, i + 1);
                }

                else if ((map_freq.get(rra_top[i]) == map_freq.get(rra_top[i + 1])) && (rra_top[i] > rra_top[i + 1])) {
                    swap(rra_top, i, i + 1);
                }

                else {
                    break;
                }

                i -= 1;
            }

            for (int x = 0; x < k && rra_top[x] != 0; ++x) {
                System.out.print(rra_top[x] + " ");
            }
        }

        System.out.println();
    }

    private static void swap(int[] rra, int x, int y) {
        int temp = rra[x];
        rra[x] = rra[y];
        rra[y] = temp;
    }
}

// import java.util.*;

// public class TopKMostFrequentNumberInAStream {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int t = sc.nextInt();

// for (int test = 0; test < t; test++) {
// int n = sc.nextInt();
// int k = sc.nextInt();
// int[] A = new int[n];
// for (int i = 0; i < A.length; i++) {
// A[i] = sc.nextInt();
// }
// kTop(A, n, k);
// }
// }

// static int find(int[] arr, int ele) {
// for (int i = 0; i < arr.length; i++)
// if (arr[i] == ele)
// return i;
// return -1;
// }

// static void kTop(int[] a, int n, int k) {
// // vector of size k+1 to store elements
// int[] top = new int[k + 1];

// // array to keep track of frequency
// HashMap<Integer, Integer> freq = new HashMap<>();
// for (int i = 0; i < k + 1; i++)
// freq.put(i, 0);

// // iterate till the end of stream
// for (int m = 0; m < n; m++) {
// // increase the frequency
// if (freq.containsKey(a[m]))
// freq.put(a[m], freq.get(a[m]) + 1);
// else
// freq.put(a[m], 1);

// // store that element in top vector
// top[k] = a[m];

// // search in top vector for same element
// int i = find(top, a[m]);
// i -= 1;

// // iterate from the position of element to zero
// while (i >= 0) {
// // compare the frequency and swap if higher
// // frequency element is stored next to it
// if (freq.get(top[i]) < freq.get(top[i + 1])) {
// int temp = top[i];
// top[i] = top[i + 1];
// top[i + 1] = temp;
// }

// // if frequency is same compare the elements
// // and swap if next element is high
// else if ((freq.get(top[i]) == freq.get(top[i + 1])) && (top[i] > top[i + 1]))
// {
// int temp = top[i];
// top[i] = top[i + 1];
// top[i + 1] = temp;
// }

// else
// break;
// i -= 1;
// }

// // print top k elements
// for (int j = 0; j < k && top[j] != 0; ++j)
// System.out.print(top[j] + " ");
// }
// System.out.println();
// }
// }