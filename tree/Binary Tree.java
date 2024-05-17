package tree;
import java.util.*;

import Main;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.maxPathSum());
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;
        private int max = Integer.MIN_VALUE; // Define max as an instance variable

        public BinaryTree() {
            this.root = this.takeInput();
        }

        public Node takeInput() {
            String[] nodes = scn.nextLine().split(" ");
            return constructTree(nodes, new int[]{0});
        }

        private Node constructTree(String[] nodes, int[] index) {
            if (index[0] >= nodes.length || nodes[index[0]].equals("NULL")) {
                index[0]++;
                return null;
            }

            Node node = new Node();
            node.data = Integer.parseInt(nodes[index[0]]);
            index[0]++;

            node.left = constructTree(nodes, index);
            node.right = constructTree(nodes, index);

            return node;
        }

        public int maxPathSum() {
            maxPathSum(root);
            return max;
        }

        private int maxPathSum(Node root) {
            if (root == null) {
                return 0;
            }
            int l = maxPathSum(root.left);
            int r = maxPathSum(root.right);
            if (l < 0)
             l = 0;
            if (r < 0)
             r = 0;
            max = Math.max(max, l + r + root.data);
            return root.data + Math.max(l, r);
        }
    }
}
