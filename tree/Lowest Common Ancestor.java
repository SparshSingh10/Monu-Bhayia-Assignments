package tree;
import java.util.*;

import Main;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt1 = m.new BinaryTree();
        TreeNode lca = bt1.lowestCommonAncestor();
        if (lca != null) {
            System.out.println(lca.data);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }

    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    private class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public TreeNode takeInput(TreeNode parent, boolean ilc) {
            int cdata = scn.nextInt();
            TreeNode child = new TreeNode(cdata);

            // left
            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public TreeNode lowestCommonAncestor() {
            int p = scn.nextInt();
            int q = scn.nextInt();
            return this.lowestCommonAncestor(root, p, q);
        }

        private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
            if(root==null)
        return null;
        if(root.data==p || root.data==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
      else if(right==null)
            return left;
        else
            return root;
        }
    }
}
