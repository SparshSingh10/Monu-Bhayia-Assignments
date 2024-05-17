import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []A=new int[n];
        for(int i=0;i<n;i++)
        {
            A[i]=sc.nextInt();
        }
        int []aarr=new int[A.length+1];
        Arrays.fill(aarr,-1);
        int m1=hrrr(A,aarr,0,A.length-1);
        Arrays.fill(aarr,-1);
        int m2=hrrr(A,aarr,1,A.length);
        System.out.print(Math.max(m1,m2));
    }
    public static int hrrr(int []nnmms,int []aarr, int start,int end)
    {
        if(start>=end)
        {
            return 0;
        }
        if(aarr[start]!=-1)
        {
            return aarr[start];
        }
        int rob=hrrr(nnmms,aarr,start+2,end)+nnmms[start];
        int drrbb=hrrr(nnmms,aarr,start+1,end);
        aarr[start]=Math.max(rob,drrbb);
        return aarr[start];
    }
}