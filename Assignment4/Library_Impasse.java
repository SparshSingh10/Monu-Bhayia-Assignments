import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import tree.TreeNode;

class TreeNode {
    char data;
    TreeNode left, right;

    public TreeNode(char item) {
        data = item;
        left = right = null;
    }
}

public class Library_Impasse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        while (T-- > 0) {
            String input = sc.nextLine().trim();
            TreeNode root = buildExpressionTree(input);
            printLevelOrder(root);
            System.out.println();
        }
    }

    private static TreeNode buildExpressionTree(String input) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ' ') {
                continue; // Skip spaces
            } else if (Character.isLetterOrDigit(c)) {
                TreeNode node = new TreeNode(c);
                stack.push(node);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char operator = operators.pop();
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode newNode = new TreeNode(operator);
                    newNode.left = left;
                    newNode.right = right;
                    stack.push(newNode);
                }
                operators.pop(); // Pop the '('
            } else {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    char operator = operators.pop();
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode newNode = new TreeNode(operator);
                    newNode.left = left;
                    newNode.right = right;
                    stack.push(newNode);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            char operator = operators.pop();
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            TreeNode newNode = new TreeNode(operator);
            newNode.left = left;
            newNode.right = right;
            stack.push(newNode);
        }

        return stack.pop();
    }

    private static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
