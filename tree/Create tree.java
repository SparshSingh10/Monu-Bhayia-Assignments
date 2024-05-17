package tree;
import java.util.*;

import Main;
public class Main {
	static int preIndex = 0;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;

		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.constructTree(in,pre, 0,in.length - 1);
		}

		private Node constructTree(int[] in ,int[] pree, int si1, int ei) {
			if(si1>ei){
            	return null;
        	}
 
        	Node nn = new Node();

			nn.data = pree[preIndex++];

        	int iiii = -1;

        	for (int i = si1; i <= ei ; i++) {





            	if(in[i] == nn.data){

                	iiii=i;

                	break;

    			}

			}	

        	nn.left = constructTree(in, pree, si1, iiii - 1);

			nn.right = constructTree(in, pree, iiii + 1, ei);

			return nn;

		}


		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String strr = "";

			if (node.left != null) {
				strr += node.left.data;
			} else {
				strr += "END";
			}

			strr += " => " + node.data + " <= ";

			if (node.right != null) {
				strr += node.right.data;
			} else {
				strr += "END";
			}

			System.out.println(strr);

			this.display(node.left);
			this.display(node.right);
		}

	}

}