import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int jkcskc=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<m;i++)b[i]=sc.nextInt();
        Integer pp[][][]=new Integer[n][m][jkcskc+1];
        System.out.println(lacamcm(a,b,0,0,jkcskc,pp));
    }
    static int lacamcm(int a[],int b[],int i,int j,int jkcskc,Integer pp[][][]){
        if(i==a.length||j==b.length)return 0;
        if(pp[i][j][jkcskc]!=null)return pp[i][j][jkcskc];
        int asnsns=0;
        if(a[i]==b[j]){
            asnsns=1+lacamcm(a,b,i+1,j+1,jkcskc,pp);
        }
        else{
            asnsns=lacamcm(a,b,i+1,j,jkcskc,pp);
            asnsns=Math.max(lacamcm(a,b,i,j+1,jkcskc,pp),asnsns);
            if(jkcskc>0){
                asnsns=Math.max(asnsns,1+lacamcm(a,b,i+1,j+1,jkcskc-1,pp));
            }
        }
        return pp[i][j][jkcskc]=asnsns;
    }
}