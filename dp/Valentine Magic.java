import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int b[]=new int[n];
        int g[]=new int[m];
        for(int i=0;i<n;i++)b[i]=sc.nextInt();
        for(int i=0;i<m;i++)g[i]=sc.nextInt();
        Arrays.sort(b);
        Arrays.sort(g);
        int pp[][]=new int[n][m];
        System.out.println(mddd(b,g,0,0,pp));
    }
    public static int mddd(int []bbby,int []gls,int i,int j,int pp[][]){
        if(i==bbby.length)return 0;
        if(j==gls.length)return 10000000;
        if(pp[i][j]!=0)return pp[i][j];
        int prr=Math.abs(bbby[i]-gls[j])+mddd(bbby,gls,i+1,j+1,pp);
        int noprr=mddd(bbby,gls,i,j+1,pp);
        return pp[i][j]=Math.min(prr,noprr);
    }
}