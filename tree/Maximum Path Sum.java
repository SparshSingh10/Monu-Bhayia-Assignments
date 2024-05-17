package tree;
import java.util.*;

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

    public static int maxPathSum(TreeNode root) {
        int[] maxSum = { Integer.MIN_VALUE };
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private static int maxPathSumHelper(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftMax = maxPathSumHelper(node.left, maxSum);
        int rightMax = maxPathSumHelper(node.right, maxSum);

        int currentMax = node.val + leftMax + rightMax;
        maxSum[0] = Math.max(maxSum[0], currentMax);

        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] input = scn.nextLine().split(" ");

        TreeNode root = buildTree(input, 0);

        int result = maxPathSum(root);
        System.out.println(result);
    }

    public static TreeNode buildTree(String[] input, int index) {
        if (index >= input.length || input[index].equals("-1")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(input[index]));
        root.left = buildTree(input, 2 * index + 1);
        root.right = buildTree(input, 2 * index + 2);

        return root;
    }
}
