import java.util.*;
public class Main {

    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		 int n2=sc.nextInt();

		 int []B=new int[n2];
		for(int i=0;i<B.length;i++)

		 {

			 B[i]=sc.nextInt();

		 }

		int resssu=0;

		    HashSet<Integer>sstr=new HashSet<>();

		    int j=0;

		  for(int i=0;i<B.length;i++)

	    	{

			while(j<B.length && !sstr.contains(B[j]))

			{


				sstr.add(B[j]);
				j++;

 			}

 			resssu+=((j-i)*(j-i+1))/2;
 
 			sstr.remove(B[i]);

 		}
 
		System.out.println(resssu);
    }

}

 