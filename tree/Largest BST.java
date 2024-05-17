package tree;
import java.util.Scanner;

class Main {
    static class BinaryTree {

        private class Node {
            int data;
            Node left;
            Node right;

            Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        private Node root;
        private int size;

        public int size() {
            return this.size;
        }

        public boolean isempty() {
            return this.size == 0;
        }

        public BinaryTree() {
            Scanner scn = new Scanner(System.in);
            this.root = this.takeinput(scn, null, false);
        }

        private Node takeinput(Scanner scn, Node parent, boolean leftorright) {
            int cdata = scn.nextInt();
            Node child = new Node(cdata, null, null);
            this.size++;
            boolean choice = false;
            choice = scn.nextBoolean();
            if (choice) {
                child.left = this.takeinput(scn, child, true);
            }
            choice = scn.nextBoolean();
            if (choice) {
                child.right = this.takeinput(scn, child, false);
            }
            return child;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node.left != null) {
                System.out.print(node.left.data + " => ");
            } else {
                System.out.print("END => ");
            }
            System.out.print(node.data + " <= ");
            if (node.right != null) {
                System.out.print(node.right.data);
            } else {
                System.out.print("END");
            }
            System.out.println();
            if (node.left != null) {
                this.display(node.left);
            }
            if (node.right != null) {
                this.display(node.right);
            }
        }

        /////////////////// New Constructor//////////

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, in, 0, in.length - 1); // for postorder
        }

        private static int preIndex = 0;

        private Node construct(int[] pre, int[] in, int isi, int iei) {
            if (isi > iei) {
                return null;
            }
            Node tNode = new Node(pre[preIndex++], null, null);

            if (isi == iei) {
                return tNode;
            }

            int inIndex = search(in, isi, iei, tNode.data);
            tNode.left = construct(pre, in, isi, inIndex - 1);
            tNode.right = construct(pre, in, inIndex + 1, iei);
            return tNode;
        }

        private int search(int[] arr, int si, int ei, int data) {
            for (int i = si; i <= ei; i++) {
                if (arr[i] == data)
                    return i;
            }
            return -1;
        }

        class Info {
            int size;
            int max;
            int min;
            int ans;
            boolean isBST;

            Info(int s, int max, int min, int ans, boolean isBST) {
                this.size = s;
                this.max = max;
                this.min = min;
                this.ans = ans;
                this.isBST = isBST;
            }
        }

        public int largestBSTinBT() {
            return this.largestBSTinBT(this.root).ans;
        }

        // Complete this
        private Info largestBSTinBT(Node root) {
            if (root == null) {
                return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
            }

            Info left = largestBSTinBT(root.left);
            Info right = largestBSTinBT(root.right);

            Info returnInfo = new Info(0, 0, 0, 0, false);
            if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
                returnInfo.size = left.size + right.size + 1;
                returnInfo.max = Math.max(root.data, right.max);
                returnInfo.min = Math.min(root.data, left.min);
                returnInfo.ans = returnInfo.size;
                returnInfo.isBST = true;
            } else {
                returnInfo.size = Math.max(left.size, right.size);
                returnInfo.ans = returnInfo.size;
                returnInfo.isBST = false;
            }

            return returnInfo;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] pre = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in[i] = scn.nextInt();
        }

        BinaryTree bt = new BinaryTree(pre, in);
        System.out.println(bt.largestBSTinBT());
    }
}
