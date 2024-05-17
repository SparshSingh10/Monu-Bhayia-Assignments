import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
         
		    int n=sc.nextInt();
         
		    int cjscj[][]=new int[n][3];
         
		    for(int i=0;i<n;i++){
         
		        for(int j=0;j<3;j++)cjscj[i][j]=sc.nextInt();
         
		    }
         
		    for(int i=1;i<n;i++){
         
		        cjscj[i][0]+=Math.min(cjscj[i-1][1],cjscj[i-1][2]);
         
		        cjscj[i][1]+=Math.min(cjscj[i-1][0],cjscj[i-1][2]);
         
		        cjscj[i][2]+=Math.min(cjscj[i-1][0],cjscj[i-1][1]);
         
		    }
         
		    Arrays.sort(cjscj[n-1]);
         
		    System.out.println(cjscj[n-1][0]);
        }

    }
	
}