import java.util.*;
class Node {
     int data;
     Node left, right;

     Node(int item) {
         data = item;
        left = right = null;
     }
}

public class Main {
    public static Node createTree(Scanner sc) {
         int item = sc.nextInt();
        Node nn = new Node(item);
         boolean hlc1 = sc.nextBoolean();
         if (hlc1) {
            nn.left = createTree(sc);
         }
         boolean hrc1 = sc.nextBoolean();
        if (hrc1) {
            nn.right = createTree(sc);
        }
        return nn;
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = createTree(scanner);
        int depth = maxDepth(root);
        System.out.println(depth);

        scanner.close();
    }
}
