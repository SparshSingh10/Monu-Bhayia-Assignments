import java.util.*;

public class SortGame {
    // public static void main(String[] args) {
    // Scanner rubix = new Scanner(System.in);
    // int x = rubix.nextInt();
    // int t = rubix.nextInt();
    // TreeMap<String, Integer> map = new TreeMap<>();
    // while (t-- > 0) {
    // String key = rubix.next();
    // int val = rubix.nextInt();
    // map.put(key, val);
    // }
    // game(map);
    // }

    // private static void game(TreeMap<String, Integer> map) {
    // Collections.sort(map, new Comparator<TreeMap<String, Integer>>() {
    // @Override
    // public int compare(TreeMap<String, Integer> o1, TreeMap<String, Integer> o2)
    // {
    // return (o1.getValue().compareTo(o2.getValue()));
    // }
    // });
    // System.out.println(map);
    // }

    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int x = rubix.nextInt();
        int t = rubix.nextInt();
        Pair[] arr = new Pair[t];
        for (int i = 0; i < t; i++) {
            String name = rubix.next();
            int salary = rubix.nextInt();
            arr[i] = new Pair(name, salary);
        }
        game(arr, x);

    }

    private static void game(Pair[] rra, int x) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < rra.length; i++) {
            if (rra[i].salary < x) {
                continue;
            }
            list.add(rra[i]);
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.salary - o1.salary;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            System.out.println(p.name + " " + p.salary);
        }
    }

    static class Pair {
        String name;
        int salary;

        public Pair() {

        }

        public Pair(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
    }
}
