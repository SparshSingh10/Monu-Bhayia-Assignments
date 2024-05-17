package tree;
import java.util.*;

import Main;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt1 = m.new BinaryTree();
        bt1.replacesum(bt1);
        bt1.preorderTraversal();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;

            public Node(int data) {
                this.data = data;
            }
        }

        private Node root;
        private int size;

        public BinaryTree() {
            int n = scn.nextInt();
            int[] inorder = new int[n];
            for (int i = 0; i < n; i++) {
                inorder[i] = scn.nextInt();
            }
            this.root = buildBSTFromInorder(inorder, 0, n - 1);
        }

        private Node buildBSTFromInorder(int[] inorder, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            Node node = new Node(inorder[mid]);

            node.left = buildBSTFromInorder(inorder, left, mid - 1);
            node.right = buildBSTFromInorder(inorder, mid + 1, right);

            return node;
        }

        public void replacesum(BinaryTree other) {
            this.replacesum(this.root, new int[]{0});
        }

        private void replacesum(Node root, int[] sum) {
            if (root == null)
                return;

            
            replacesum(root.right, sum);

            
            root.data += sum[0];
            sum[0] = root.data;

            replacesum(root.left, sum);
        }

        public void preorderTraversal() {
            preorderTraversal(this.root);
        }

        private void preorderTraversal(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
