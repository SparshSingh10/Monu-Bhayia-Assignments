import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int[n];
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			 arr[i]=sc.nextInt();
			if(map.containsKey(arr[i]))
				map.put(arr[i],map.get(arr[i])+1);
			else
				map.put(arr[i],1);
	}
	int max=0;
	int number=0;
	for(int i=0;i<arr.length;i++){
		if(map.get(arr[i])>max){
			max=map.get(arr[i]);
			number=arr[i];
		}
	}

	System.out.println(number);
    }
}