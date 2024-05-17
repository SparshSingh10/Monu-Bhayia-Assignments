// Take as input N, the size of array. Take N more inputs and store that in an array. Take N more inputs and store that in another array. Write a function which gives the intersection of two arrays in an ArrayList of integers and Print the ArrayList.

import java.util.*;

public class ArraysIntersectionOfTwoArrays {

    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int num = rubix.nextInt();
        int[] arr1 = new int[num];
        for (int l = 0; l < arr1.length; l++) {
            arr1[l] = rubix.nextInt();
        }
        int[] arr2 = new int[num];
        for (int l = 0; l < arr2.length; l++) {
            arr2[l] = rubix.nextInt();
        }

        System.out.println(intersection(arr1, arr2));
    }

    private static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) == null) {
                map.put(arr1[i], 1);
            } else {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                list.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
        Collections.sort(list);
        return list;
    }
}