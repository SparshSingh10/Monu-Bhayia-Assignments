// Shekhar is a bomb defusal specialist. He once encountered a bomb that can be defused only by a secret code. He is given a number N and a number K. And he is also given permutation of first N natural numbers . The defusal code is the largest permutation possible by doing atmost K swaps among a pair of the given permutation. Help him to find the final permutation.

import java.util.*;

public class Unlock {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int size = rubix.nextInt();
        int swap = rubix.nextInt();
        int[] rra = new int[size];
        for (int l = 0; l < rra.length; l++) {
            rra[l] = rubix.nextInt();
        }
        int[] ans = code(rra, swap);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    private static int[] code(int[] rra, int swap) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rra.length; i++) {
            map.put(rra[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < rra.length; i++) {
            list.add(rra[i]);
        }
        Collections.sort(list);
        int x = 0;
        while (swap >= 1) {
            if (list.size() == 0) {
                break;
            }
            int val = list.get(list.size() - 1);
            if (map.get(val) == x) {
                list.remove(list.size() - 1);
                x++;
            } else {
                int num = map.get(val);
                swap(rra, x, num);
                map.put(rra[x], x);
                map.put(rra[num], num);
                x++;
                swap--;
                list.remove(list.size() - 1);
            }
        }
        return rra;
    }

    private static void swap(int[] rra, int i, int j) {
        int temp = rra[i];
        rra[i] = rra[j];
        rra[j] = temp;
    }
}
