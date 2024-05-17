import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        levelOrderBottomUp(root);
    }

    public static Node buildTree(String s)
    {
        
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] values = s.split(" ");
        Node root = new Node(Long.parseLong(values[0]));
        //
        //
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < values.length; i += 2)
        {
            Node current = q.poll();

            if (!values[i].equals("N")) 
            {
                current.left = new Node(Long.parseLong(values[i]));
                q.add(current.left);
            }

            if (i + 1 < values.length && !values[i + 1].equals("N"))
            {
                current.right = new Node(Long.parseLong(values[i + 1]));
                q.add(current.right);
            }
        }

        return root;
    }

    public static void levelOrderBottomUp(Node root) 
    {
        
     
        Queue<Node> qq = new LinkedList<>();
     
        Stack<List<Long>> stack = new Stack<>();
     
        qq.add(root);
     
        int nodeincc = 1;
     
        List<Long> levelValues = new ArrayList<>();


        while (!qq.isEmpty()) {

            Node ccc = qq.poll();

            nodeincc--;



            levelValues.add(ccc.key);



            if (ccc.left != null) {

                qq.add(ccc.left);
            }

            if (ccc.right != null) {

                qq.add(ccc.right);

            }




            if (nodeincc == 0) {

                stack.push(levelValues);

                levelValues = new ArrayList<>();
                nodeincc = qq.size();

            }

        }
        while (!stack.isEmpty()) {
            List<Long> level = stack.pop();
            for (Long value : level) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    long key;
    Node left;
    Node right;

    Node(long k) {
        key = k;
    }
}