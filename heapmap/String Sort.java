import java.util.*;
public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        String[] arr = new String[size1];
        for (int l = 0; l < arr.length; l++) {
            arr[l] = sc.next();
        }
        sort(arr);
    }

    private static void sort(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length() && s1.equals(s2.substring(0, s1.length()))) {
                    return s2.compareTo(s1);
                } else if (s2.length() < s1.length() && s2.equals(s1.substring(0, s2.length()))) {
                    return s2.compareTo(s1);
                }
                return s1.compareTo(s2);
            }
        });

        for (String str : arr) {
            System.out.println(str);
        }
    }
}