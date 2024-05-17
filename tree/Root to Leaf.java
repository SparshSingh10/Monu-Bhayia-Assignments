package tree;
import java.util.*;

import Main;

public class Main {
    public static void main(String args[]) {
        Main m = new Main();
        BinaryTree bt = m.new BinaryTree();
        bt.path();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        Scanner scn = new Scanner(System.in);

        public Node takeInput(Node parent, boolean ilc) {
            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

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

        public void path() {
            int x = scn.nextInt();
            path(root, x, "");
        }

        private void path(Node root, int x, String str) {
            if (root == null)
                return;

            if (x - root.data == 0 && root.left == null && root.right == null) {
                System.out.println(str + root.data);
                return;
            }
            path(root.left, x - root.data, str + root.data + " ");
            path(root.right, x - root.data, str + root.data + " ");
        }
    }
}
