import java.util.*;
public class Main{
    public static void main (String args[]) {
  
        Scanner sc=new Scanner(System.in);
  
        int n=sc.nextInt();
  
        int ccc[]=new int[3];
  
        Long dp[]=new Long[n+1];
  
        ccc[0]=1;ccc[1]=3;ccc[2]=4;
  
        System.out.println(chg(n,ccc,dp));
  
    }
  
    public static long chg(int amount, int[] ccc,Long dp[]) {
  
        if(amount==0)return 1;
  
        if(dp[amount]!=null)return dp[amount];
        long app=0;
  
        for(int i=0;i<3;i++){
  
            if(amount-ccc[i]>=0){
  
                app+=chg(amount-ccc[i],ccc,dp);
  
            }
        }
  
        return dp[amount]=app;
  
    }
}

