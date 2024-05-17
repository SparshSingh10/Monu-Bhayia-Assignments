import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int k=sc.nextInt();
		PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
		while(t-->0){
			int type=sc.nextInt();
			if(type==1){
				long x=sc.nextInt();
				long y=sc.nextInt();
				cal(k,x,y,pq);
			}
			else{
				System.out.println(pq.peek());
			}
		}
    }
	public static void cal(int k,long x,long y,PriorityQueue<Long>pq){
		long distance=x*x+y*y;
		pq.add(distance);
		if(pq.size()>k){
			pq.poll();
		}
	}
}