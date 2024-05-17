import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
      
	    String a=sc.next();
        String b=sc.next();
      
	    int pp[][]=new int[a.length()+1][b.length()+1];
      
	    for(int i=1;i<pp.length;i++){
      
	        for(int j=1;j<pp[0].length;j++){
      
	            if(a.charAt(i-1)==b.charAt(j-1)){
      
	                pp[i][j]=1+pp[i-1][j-1];
      
	            }
      
	            else {
      
	                pp[i][j]=Math.max(pp[i-1][j],pp[i][j-1]);
      
	            }
      
	        }
        }
        System.out.println(pp[pp.length-1][pp[0].length-1]);
    }
}