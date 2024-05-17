import java.util.*;
import java.util.TreeMap;

import java.util.Vector;

public class Main {

    public static void main(String args[]) {

		Scanner sc=new Scanner(System.in);

		int levels=sc.nextInt();

		int n=sc.nextInt();

		Queue<Node>q=new LinkedList<>();

		Node foooot=new Node(n);

		q.add(foooot);
		int lv;

		int rv;

		while(!q.isEmpty())

		{

			Node temporryyee=q.poll();
			lv=sc.nextInt();

			rv=sc.nextInt();

			if(lv!=-1)

			{

				temporryyee.left=new Node(lv);
				q.add(temporryyee.left);

			}

			if(rv!=-1)

			{
				temporryyee.right=new Node(rv);
				q.add(temporryyee.right);

			}

		}

		vjjd (foooot);

    }

    public static void

    vjjd (Node foooot, int ddeepp,

                     TreeMap<Integer, Vector<Integer> > m)
     {
 
        if (foooot == null)
 
            return;


        Vector<Integer> get = m.get(ddeepp);

        if (get == null) 
 
 		{
             get = new Vector<>();
  
  
             get.add(foooot.key);
        }
   
          else
  
            get.add(foooot.key);
  

 
        m.put(ddeepp, get);

  
 
         vjjd (foooot.left, ddeepp - 1, m);





 
        vjjd (foooot.right, ddeepp + 1, m);
    }
 
    public static void vjjd (Node foooot)
  
     {
   
         TreeMap<Integer, Vector<Integer> > m= new TreeMap<>();
   
        int ddeepp = 0;
        vjjd (foooot, ddeepp, m);
  
        for(Map.Entry<Integer, Vector<Integer> > entry :m.entrySet()) 
		 
		
	 	  {
 			Vector<Integer>temporryyee=entry.getValue(); 

			
			 for(Integer x:temporryyee)
             System.out.print(x+" ");
       
	   
	      }
    }

 
  }
class Node{
	int key;
	Node left;
	Node right;
	Node(int k)
	{
		key=k;
	}
}