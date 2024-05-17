import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static class BinaryTreeFromLvlOrder {

        private Scanner s = new Scanner(System.in);

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        private TreeNode root;

        public BinaryTreeFromLvlOrder() {
            // TODO Auto-generated constructor stub
            root = construct(); // 2k
        }

        private TreeNode construct() {
            // TODO Auto-generated method stub

            int val = s.nextInt();
            TreeNode nn = new TreeNode(val);
            Queue<TreeNode> lvl = new LinkedList<>();
            lvl.add(nn);

            while (!lvl.isEmpty()) {
                TreeNode front = lvl.remove();
                int a = s.nextInt();
                int b = s.nextInt();

                if (a != -1) {
                    TreeNode na = new TreeNode(a);
                    front.left = na;
                    lvl.add(na);
                }

                if (b != -1) {
                    TreeNode nb = new TreeNode(b);
                    front.right = nb;
                    lvl.add(nb);
                }
            }
            return nn; // 2k
        }

        private boolean isValid() {
            BestPair ans = ValidBST(root);
            return ans.isbst;
        }

        public BestPair ValidBST(TreeNode root) {
            if (root == null) {
                return new BestPair();
            }
            BestPair lbp = ValidBST(root.left);
            BestPair rbp = ValidBST(root.right);
            BestPair sbp = new BestPair();
            sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
            sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
            if (lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val) {
                sbp.isbst = true;
            } else {
                sbp.isbst = false;
            }
            return sbp;
        }

        class BestPair {
            boolean isbst = true;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        BinaryTreeFromLvlOrder bt = new BinaryTreeFromLvlOrder();
        System.out.println(bt.isValid());
    }
}
