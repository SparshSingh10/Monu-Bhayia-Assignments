import java.util.*;
public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
	    int size = sc.nextInt();
        int swap1 = sc.nextInt();
       
	    int[] arr = new int[size];
       
	    for (int l = 0; l < arr.length; l++) {
            arr[l] = sc.nextInt();
       
	    }
       
	    int[] aa = fun(arr, swap1);
        for (int i = 0; i < aa.length; i++) {
       
	        System.out.print(aa[i] + " ");
       
	    }

    }

    private static int[] fun(int[] arr, int swap1) {
   
        HashMap<Integer, Integer> map = new HashMap<>();
   
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
   
        }
   
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
   
            lis.add(arr[i]);
        }
        Collections.sort(lis);
   
        int x = 0;
        while (swap1 >= 1) {
            if (lis.size() == 0) {
   
                break;
            }
            int val = lis.get(lis.size() - 1);
   
            if (map.get(val) == x) {
   
                lis.remove(lis.size() - 1);
   
                x++;
            } else {
   
                int num = map.get(val);
                swap1(arr, x, num);
   
                map.put(arr[x], x);
   
                map.put(arr[num], num);
   
                x++;
   
                swap1--;
   
                lis.remove(lis.size() - 1);
   
            }
   
        }
   
        return arr;
   
    }



    private static void swap1(int[] arr, int i, int j) {

        int temporary = arr[i];
        arr[i] = arr[j];

        arr[j] = temporary;

    }

}