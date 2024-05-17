// Nishant is a very naughty boy in Launchpad Batch. One day he was playing with strings, and randomly shuffled them all. Your task is to help Nishant Sort all the strings ( lexicographically ) but if a string is present completely as a prefix in another string, then string with longer length should come first. Eg bat, batman are 2 strings and the string bat is present as a prefix in Batman - then sorted order should have - Batman, bat.

import java.util.*;

public class StringSort {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int size = rubix.nextInt();
        String[] rra = new String[size];
        for (int l = 0; l < rra.length; l++) {
            rra[l] = rubix.next();
        }
        sorted(rra);
    }

    private static void sorted(String[] rra) {
        Arrays.sort(rra, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length() && o1.equals(o2.substring(0, o1.length()))) {
                    return o2.compareTo(o1);
                } else if (o2.length() < o1.length() && o2.equals(o1.substring(0, o2.length()))) {
                    return o2.compareTo(o1);
                }
                return o1.compareTo(o2);
            }
        });

        for (String string : rra) {
            System.out.println(string);
        }
    }
}
