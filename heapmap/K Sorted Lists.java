import java.util.*;
public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int n=sc.nextInt();
		int[] arr=new int[k*n];
		for(int i=0;i<k*n;i++){
			arr[i]=sc.nextInt();
		}

		int[] ans=merging(arr);
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}

	}
    public static int[] merging(int[] arr) {
		int[] ans = new int[arr.length];
		PriorityQueue <Integer> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
        
}
}