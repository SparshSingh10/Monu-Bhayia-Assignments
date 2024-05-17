import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int k=sc.nextInt();
			int n=sc.nextInt();
			System.out.println(cdvdvd(k,n));
		}
    }
	public static int cdvdvd(int k, int n) {
        int [][]mmoo=new int[n+1][k+1];
        for(int i=0;i<mmoo.length;i++)
        {
            Arrays.fill(mmoo[i],-1);
        }
        int eee=fn(k,n,mmoo);
        return eee;
    }
    public static int fn(int eegg,int ffll,int [][]mmoo)
    {
        if(eegg==1)
        {
            return ffll;
        }
        if(ffll==1)
        {
            return 1;
        }
        if(mmoo[ffll][eegg]!=-1)
        {
            return mmoo[ffll][eegg];
        }
        if(ffll==0)
        {
            return 0;
        }
        int mn=Integer.MAX_VALUE;
        int low=0;
        int high=ffll;
        while(low<=high)
        {
            int mid=low+(high-low)/2; 
            int left=fn(eegg-1,mid-1,mmoo);
            int right=fn(eegg,ffll-mid,mmoo);
            int temp=Math.max(left,right)+1;
       
            if(left<right)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
            mn=Math.min(temp,mn);
        }
        return mmoo[ffll][eegg]=mn;
    }
}