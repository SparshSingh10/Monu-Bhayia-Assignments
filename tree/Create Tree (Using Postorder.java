package tree;
import java.util.*;

import Main;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] post = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(post, in);
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

		public BinaryTree(int[] post, int[] in) {
			this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] post, int pllloo, int phi, int[] in, int ilo, int ihi) {
			if (pllloo > phi) {
                return null;
            }

            int hvv = post[phi];
            Node root = new Node();
            root.data = hvv;

            int hii = -1;
            for (int l = ilo; l <= ihi; l++) {
                if (in[l] == hvv) {
                    hii = l;
                    break;
  
                }
  
            }
            int ltsii = hii - ilo;
            root.left = construct(post, pllloo, pllloo + ltsii - 1, in, ilo, hii - 1);
            root.right = construct(post, pllloo + ltsii, phi - 1, in, hii + 1, ihi);
            return root;
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String sttr1 = "";

			if (node.left != null) {
				sttr1 += node.left.data;
			} else {
				sttr1 += "END";
			}

			sttr1 += " => " + node.data + " <= ";

			if (node.right != null) {
				sttr1 += node.right.data;
			} else {
				sttr1 += "END";
			}

			System.out.println(sttr1);

			this.display(node.left);
			this.display(node.right);
		}

	}

}