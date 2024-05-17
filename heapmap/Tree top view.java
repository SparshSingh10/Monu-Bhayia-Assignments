import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception{
 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
        String[] aaarryy=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(aaarryy);


 
        bt.lview();


    }

}



class BinaryTree

{

	 class QueueObj {

        Node node;

        int pdsdnjks;



        QueueObj(Node node, int pdsdnjks)
        {
            this.node = node;

            this.pdsdnjks = pdsdnjks;

			//
			//

        }
    }

  
 
    private class Node
 
    {
 




        int data;

        
		Node left,right;
	
	
		//
	
	

		//

		//

		//

		//

		//

        Node(int data)

        {

            this.data=data;
        }

    }



    Node poot;


    BinaryTree(String[] aaarryy)


    {
        Queue<Node> queue=new LinkedList<Node>();

		//

		//
		///
		//
        contrrcu(aaarryy,0,queue);
    }

    public void lview()
    {
 
         lview(this.poot);
     }
 
 
    private void lview(Node poot) {

 
 	   if (poot == null) return; 
 	   Queue<QueueObj> que = new LinkedList<>(); 
 
 	   Map<Integer, Integer> map = new HashMap<>(); 
	   int min = 0; int max = 0; 
	   que.add(new QueueObj(poot, 0)); 
	   while (!que.isEmpty()) { 

		    QueueObj curr = que.poll(); 

	   		if (!map.containsKey(curr.pdsdnjks)) {
 


 				 map.put(curr.pdsdnjks, curr.node.data);

			} 
			if (curr.node.left != null) { 
 				min = Math.min(min, curr.pdsdnjks - 1); 

				que.add(new QueueObj(curr.node.left, curr.pdsdnjks - 1)); 

 			} 

 
 			if (curr.node.right != null) { 
 
 				max = Math.max(max, curr.pdsdnjks + 1); 

				que.add(new QueueObj(curr.node.right, curr.pdsdnjks + 1)); 

			} 
 
 		} 

		for (; min <= max; min++) { 
 			int kk=map.get(min) ;

			if(kk!=-1)
 
 			System.out.print(kk+ " "); 

		} 



 	}
 
    private void contrrcu(String[] aaarryy,int ind,Queue<Node> queue)
    {
        if(ind>=aaarryy.length)
 
        return;
  
         if(queue.size()==0)
  
        {
   
             Node nn=new Node(Integer.parseInt(aaarryy[ind]));
    
	         this.poot=nn;
     
	         queue.add(nn);
      
	     }
      
	    else
      
	     {
            Node parent=queue.peek();
       
	            if(parent.data!=-1){
        
		
		         if(parent.left==null)
        
		
		
	 
	  	        {
      
	                parent.left=new Node(Integer.parseInt(aaarryy[ind]));
      
	  
	 
	  
	                 queue.add(parent.left);
       
	             }
                 else
        
		        {
                     if(parent.right==null)
         
		             {
                    parent.right=new Node(Integer.parseInt(aaarryy[ind]));
         
		 
		            queue.add(parent.right);
		
					//
		
					//
                    queue.poll();
                    }
               }
        
		       }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        contrrcu(aaarryy,ind+1,queue);
    }



    public void display()

    {
        dtree(this.poot);
    }



    private void dtree(Node poot)

    {

        if(poot==null)
        return;
        String str=poot.data+"";

        if(poot.left!=null)

        {

            str=poot.left.data+" <= "+str;
        }


        else

        {




            str="END <= "+str;

        }


        if(poot.right!=null)
        {
            str=str+" => "+poot.right.data;


        }





        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        dtree(poot.left);
        dtree(poot.right);

    }


}