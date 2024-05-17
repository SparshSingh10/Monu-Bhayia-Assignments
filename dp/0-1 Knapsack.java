import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cc=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++)a[i][1]=sc.nextInt();
        for(int i=0;i<n;i++)a[i][0]=sc.nextInt();
        Arrays.sort(a,(i1,i2)->i1[1]-i2[1]);
        int pp[][]=new int[a.length+1][cc+1];
        for (int i = 1; i < pp.length; i++) {
            for (int j = 1; j < pp[0].length; j++) {
                if(a[i-1][1]<=j){
                    pp[i][j]=Math.max(pp[i-1][j],pp[i-1][j-a[i-1][1]]+a[i-1][0]);
                }
                else {
                    pp[i][j]=pp[i-1][j];
                }
            }
        }
        System.out.println(pp[pp.length-1][pp[0].length-1]);
    }
}