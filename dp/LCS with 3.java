import java.util.*;
public class Main{
    public static void main(String args[]) {
  
        Scanner sc=new Scanner(System.in);
  
        String a=sc.next();
  
        String b=sc.next();
  
        String c=sc.next();
  
        Integer pp[][][]=new Integer[a.length()][b.length()][c.length()];
  
        System.out.println(llccss(a,b,c,0,0,0,pp));
  
    }
  
    static int llccss(String a,String b,String c,int i,int j,int k,Integer pp[][][]){
  
        if(i==a.length()||j==b.length()||k==c.length())
		return 0;
  
        if(pp[i][j][k]!=null)
		
		return pp[i][j][k];
  
        int ans=0;
  
        if(a.charAt(i)==b.charAt(j)&&a.charAt(i)==c.charAt(k)){
  
            ans=1+llccss(a,b,c,i+1,j+1,k+1,pp);
  
        }
  
        else{
  
            ans=llccss(a,b,c,i,j,k+1,pp);
  
            ans=Math.max(ans,llccss(a,b,c,i,j+1,k,pp));
  
            ans=Math.max(ans,llccss(a,b,c,i+1,j,k,pp));
  
        }
  
        return pp[i][j][k]=ans;
  
    }
}