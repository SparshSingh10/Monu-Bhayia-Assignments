import java.util.*;
public class Main{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Long> sssdd=new HashMap<>();
        System.out.println(ffnn(n,sssdd));
    }
    static long ffnn(int n,Map<Integer,Long> sssdd){
        if(n==0)
		return 0;
        
		if(sssdd.containsKey(n))
		return sssdd.get(n);
        long assss=Math.max(n,ffnn(n/2,sssdd)+ffnn(n/3,sssdd)+ffnn(n/4,sssdd));
        
		sssdd.put(n,assss);
        
		return assss;
    }
}