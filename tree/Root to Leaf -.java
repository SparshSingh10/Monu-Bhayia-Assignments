package tree;
import java.util.*;

import TreeNode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int sum = scanner.nextInt();

        TreeNode root = constructTree(arr);
        int count = countPaths(root, sum);
        System.out.println(count);
    }

    public static TreeNode constructTree(int[] arr) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode node = queue.poll();

            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                queue.offer(node.right);
            }
        }

        return root;
    }

    public static int countPaths(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null && sum - root.val == 0)
            return 1;

        int leftCount = countPaths(root.left, sum - root.val);
        int rightCount = countPaths(root.right, sum - root.val);

        return leftCount + rightCount;
    }
}
