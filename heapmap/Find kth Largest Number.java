import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(klarge(arr,k));
    }
	private static int klarge(int[] arr,int k){
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size()>k)
				pq.poll();
		}
	return pq.peek();
	}
}