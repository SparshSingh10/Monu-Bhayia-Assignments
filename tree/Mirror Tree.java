package tree;
import java.util.Scanner;

import TreeNode;


class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
 
     TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    public static boolean isMirror(TreeNode root) {
        return equal(root, root);
    }

     public static boolean equal(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
             return true;
         }
         if (node1 == null || node2 == null) {
             return false;
        }
         return (node1.val == node2.val && equal(node1.left, node2.right));
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
        String[] ip = input.split(" ");
         TreeNode[] nodes = new TreeNode[ip.length];
         for (int i = 0; i < ip.length; i++) {
            if (!ip[i].equals("-1")) {
                 nodes[i] = new TreeNode(Integer.parseInt(ip[i]));
             }
        }
        
         for (int i = 0; i < ip.length; i++) {
             if (nodes[i] != null) {
                 int li = 2 * i + 1;
                int ri = 2 * i + 2;
                 if (li < ip.length) {
                     nodes[i].left = nodes[li];
                 }
                if (ri < ip.length) {
                     nodes[i].right = nodes[ri];
                 }
             }
         }
         
          TreeNode root = nodes[0];
          if (isMirror(root)) {
             System.out.println("YES");
         } else {
             System.out.println("NO");
          }  

        sc.close();
    }
} 
