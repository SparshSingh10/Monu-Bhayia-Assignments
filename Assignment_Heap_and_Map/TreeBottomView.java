import java.util.*;
import java.util.Map.Entry;

public class TreeBottomView {

    public static void viewBottom(Node tree_root) {
        if (tree_root == null)
            return;
        int xyz = 0;
        Map<Integer, Integer> tempMap = new TreeMap<>();
        Queue<Node> node_queueueue = new LinkedList<Node>();
        tree_root.xyz = xyz;
        node_queueueue.add(tree_root);
        while (!node_queueueue.isEmpty()) {
            Node nn_temp = node_queueueue.remove();
            xyz = nn_temp.xyz;
            tempMap.put(xyz, nn_temp.key);
            if (nn_temp.left != null) {
                nn_temp.left.xyz = xyz - 1;
                node_queueueue.add(nn_temp.left);
            }
            if (nn_temp.right != null) {
                nn_temp.right.xyz = xyz + 1;
                node_queueueue.add(nn_temp.right);
            }
        }
        Set<Entry<Integer, Integer>> set = tempMap.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> temp_tempMap = iterator.next();
            System.out.print(temp_tempMap.getValue() + " ");
        }
    }

    public static void main(String args[]) {
        Scanner rubix = new Scanner(System.in);
        int n = rubix.nextInt();
        Queue<Node> node_queue = new LinkedList<>();
        Node tree_root = new Node(n);
        node_queue.add(tree_root);
        int left;
        int right;
        while (!node_queue.isEmpty()) {
            Node nn_temp = node_queue.poll();
            left = rubix.nextInt();
            right = rubix.nextInt();
            if (left != -1) {
                nn_temp.left = new Node(left);
                node_queue.add(nn_temp.left);
            }
            if (right != -1) {
                nn_temp.right = new Node(right);
                node_queue.add(nn_temp.right);
            }
        }
        viewBottom(tree_root);

    }

}

class Node {
    int key;
    Node left;
    Node right;
    int xyz;

    Node(int k) {
        xyz = Integer.MAX_VALUE;
        key = k;
    }
}