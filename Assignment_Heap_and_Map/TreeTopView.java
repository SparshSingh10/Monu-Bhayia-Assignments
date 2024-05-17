import java.util.*;
import java.io.*;

public class TreeTopView {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BinaryTree bt = new BinaryTree(arr);

        bt.leftView();

    }
}

class BinaryTree {
    class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree(String[] arr) {
        Queue<Node> queue = new LinkedList<Node>();
        construct(arr, 0, queue);
    }

    public void leftView() {
        leftView(this.root);
    }

    private void leftView(Node root) {
        if (root == null)
            return;
        Queue<QueueObj> obj_que = new LinkedList<>();
        Map<Integer, Integer> tree_map = new HashMap<>();
        int min = 0;
        int max = 0;

        obj_que.add(new QueueObj(root, 0));
        while (!obj_que.isEmpty()) {
            QueueObj obj_curr = obj_que.poll();
            if (!tree_map.containsKey(obj_curr.hd)) {
                tree_map.put(obj_curr.hd, obj_curr.node.data);
            }
            if (obj_curr.node.left != null) {
                min = Math.min(min, obj_curr.hd - 1);
                obj_que.add(new QueueObj(obj_curr.node.left, obj_curr.hd - 1));
            }
            if (obj_curr.node.right != null) {
                max = Math.max(max, obj_curr.hd + 1);
                obj_que.add(new QueueObj(obj_curr.node.right, obj_curr.hd + 1));
            }
        }
        for (; min <= max; min++) {
            int tem = tree_map.get(min);
            if (tem != -1) {
                System.out.print(tem + " ");
            }
        }
    }

    private void construct(String[] arr, int ind, Queue<Node> queue) {
        if (ind >= arr.length)
            //
            //
            //
            //
            return;
        if (queue.size() == 0) {
            Node nn = new Node(Integer.parseInt(arr[ind]));
            this.root = nn;
            queue.add(nn);
        } else {
            Node parent = queue.peek();
            if (parent.data != -1) {
                if (parent.left == null) {
                    parent.left = new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                    //
                    //

                } else {
                    if (parent.right == null) {
                        parent.right = new Node(Integer.parseInt(arr[ind]));
                        queue.add(parent.right);
                        //
                        //
                        queue.poll();
                    }
                }
            } else {
                queue.poll();
                ind--;
            }
        }
        construct(arr, ind + 1, queue);
    }

    public void display() {
        display_tree(this.root);
    }

    private void display_tree(Node root) {
        if (root == null)
            return;
        String str = root.data + "";
        if (root.left != null) {
            str = root.left.data + " <= " + str;
        } else {
            str = "END <= " + str;
        }

        if (root.right != null) {
            str = str + " => " + root.right.data;
        } else {
            str = str + " => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }

}