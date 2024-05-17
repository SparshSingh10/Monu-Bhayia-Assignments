
import java.util.*;

public class VerticalOrderPrintBinaryTree {

    public static void verticalOrderDisplay(Node tree_root) {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        int xyz = 0;
        verticalOrderLaao(tree_root, xyz, map);
        for (Map.Entry<Integer, Vector<Integer>> ent : map.entrySet()) {
            Vector<Integer> vector_temp = ent.getValue();
            for (Integer x : vector_temp) {
                System.out.print(x + " ");
            }
        }
    }

    public static void verticalOrderLaao(Node tree_root, int xyz, TreeMap<Integer, Vector<Integer>> m) {
        if (tree_root == null)
            return;

        Vector<Integer> get = m.get(xyz);
        if (get == null) {
            get = new Vector<>();
            get.add(tree_root.key);
        } else
            get.add(tree_root.key);

        m.put(xyz, get);

        verticalOrderLaao(tree_root.left, xyz - 1, m);
        verticalOrderLaao(tree_root.right, xyz + 1, m);
    }

    public static void main(String args[]) {
        Scanner rubix = new Scanner(System.in);
        int levels = rubix.nextInt();
        int n = rubix.nextInt();
        Queue<Node> nodes_queue = new LinkedList<>();
        Node tree_root = new Node(n);
        nodes_queue.add(tree_root);
        int left;
        int right;
        while (!nodes_queue.isEmpty()) {
            Node temp = nodes_queue.poll();
            left = rubix.nextInt();
            right = rubix.nextInt();
            if (left != -1) {
                temp.left = new Node(left);
                nodes_queue.add(temp.left);
            }
            if (right != -1) {
                temp.right = new Node(right);
                nodes_queue.add(temp.right);
            }
        }
        verticalOrderDisplay(tree_root);
    }

}

class Node {
    int key;
    Node left;
    Node right;

    Node(int k) {
        key = k;
    }
}
