import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
   
        int tc=sc.nextInt();
   
        for(int outerloop=0;outerloop<tc;outerloop++)
   
        {
            int n=sc.nextInt();
   
            int []B=new int[n];
   
            for(int j=0;j<n;j++)
   
            {
   
                B[j]=sc.nextInt();
            }
   
            median(B);
   
            System.out.println();
   
        }
   
    }
   
 
    public static void median(int[ ]B)

    {
        List<Integer> l1=new ArrayList<>();

        List<Integer> l2=new ArrayList<>();

        for(int i=0;i<B.length;i++)
        {
            l1.add(B[i]);

            Collections.sort(l1);

            if(l1.size()%2!=0)
                l2.add(l1.get(l1.size()/2));
            else
            {
                int a=l1.get((l1.size()-1)/2);

                int b=l1.get(l1.size()/2);

                int c=(a+b)/2;

                l2.add(c);
            }
        }
        for(int i=0;i<l2.size();i++)
        {
            System.out.print(l2.get(i) + " ");
        }
    }
}

