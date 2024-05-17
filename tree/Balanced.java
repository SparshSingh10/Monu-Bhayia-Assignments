import java.util.*;
public class Main {
	boolean result=true;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
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

		public boolean isBalanced() {
			isBalanced(this.root);
			return result;
		}

		private int isBalanced(Node node) {
			 if (node == null)
                return 0;
            int left = isBalanced(node.left);
            int right = isBalanced(node.right);
            if (Math.abs(left - right) > 1) {
                result = false; // Corrected line
            }
            return 1 + left + right;
			
		}

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}

	}
}
