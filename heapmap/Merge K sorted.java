import java.util.*;
public class Main {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int[] arr=new int[n1*n2];
		for(int i=0;i<arr.length;i++){
			 arr[i]=sc.nextInt();
		}
		int[] ans=merging(arr);

		for(int i=0;i<arr.length;i++){
			System.out.print(ans[i]+" ");
		}

    }
	public static int[] merging(int [] arr){
		int[] ans=new int[arr.length];
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		for(int i=0;i<ans.length;i++){
			ans[i]=pq.poll();
		}
		return ans;
	}
}
