import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr1=new int[n];
		int[] arr2=new int[n];
		for(int i=0;i<n;i++){
			arr1[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			arr2[i]=sc.nextInt();
		}
		 System.out.println(intersetion(arr1, arr2));
		}
		public static ArrayList<Integer> intersetion(int[] arr1,int[] arr2){
			HashMap<Integer,Integer> map=new HashMap<>();
			for(int i=0;i<arr1.length;i++){
				if (map.get(arr1[i]) == null) {
    map.put(arr1[i], 1);
} else {
    map.put(arr1[i], map.get(arr1[i]) + 1);
}

				
			}
			ArrayList<Integer> list=new ArrayList<>();
			for(int i=0;i<arr2.length;i++){
				 if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                list.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
			}
			Collections.sort(list);
			return list;
		}
}