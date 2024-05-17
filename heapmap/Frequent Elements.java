import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();


        int k = sc.nextInt();
        int[] arr = new int[size];

        for (int l = 0; l < arr.length; l++) {

            arr[l] = sc.nextInt();

        }

        frequuu(arr, k);

    }


    private static void frequuu(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {

                map.put(arr[i], map.get(arr[i]) + 1);

            } else {

                map.put(arr[i], 1);

            }

        }

         ArrayList<Integer> list = new ArrayList<>(map.keySet());
 
        Collections.sort(list, new Comparator<Integer>() {
             @Override
   
             public int compare(Integer O1, Integer O2) {

     
    
	             int res = map.get(O2) - map.get(O1);
      
	             if (res == 0) {
       
	                  return O2 - O1;
       
	             }
         
	 	         return res;
    
	        }
    
	     });
      
	     ArrayList<Integer> meraans = new ArrayList<>();
       
	      for (int i = 0; i < k; i++) {
       
	        meraans.add(list.get(i));
       
	  
	     }
     
	     Collections.sort(meraans);
      
	     for (int i = 0; i < meraans.size(); i++) {
       
	        System.out.print(meraans.get(i) + " ");
         }
    }
}
