// Given an array arr of n length. You will be given Q queries for the array. Each query contains a number N.You have to determine whether a number exist in the array or not

import java.util.*;

public class ExistOrNot {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int t = rubix.nextInt();
        while (t-- > 0) {
            int size = rubix.nextInt();
            int[] rra = new int[size];
            for (int l = 0; l < rra.length; l++) {
                rra[l] = rubix.nextInt();
            }
            int q = rubix.nextInt();
            int[] query = new int[q];
            for (int l = 0; l < query.length; l++) {
                query[l] = rubix.nextInt();
            }
            doesExist(rra, query);
        }
    }

    private static void doesExist(int[] rra, int[] q) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < rra.length; i++) {
            map.put(rra[i], true);
        }

        for (int i = 0; i < q.length; i++) {
            if (map.containsKey(q[i])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
