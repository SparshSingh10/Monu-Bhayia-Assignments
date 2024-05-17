import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){
			t--;
			int n=sc.nextInt();
			int[] arr1=new int[n];
			for(int i=0;i<n;i++){
				arr1[i]=sc.nextInt();
			}
			int n2=sc.nextInt();
			int[] arr2=new int[n2];
			for(int i=0;i<n2;i++){
				arr2[i]=sc.nextInt();
			}
			doesExist(arr1,arr2);
		}
		
    }
	public static void doesExist(int [] arr1,int[] arr2){
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i=0;i<arr1.length;i++){
			map.put(arr1[i],true);
		}
		for(int i=0;i<arr2.length;i++){
			if(map.containsKey(arr2[i]))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}