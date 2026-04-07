public class BinaryTreeTraversal {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');

        tree.root.left.left = new Node('D');
        tree.root.left.right = new Node('E');

        tree.root.right.left = new Node('G');
        tree.root.right.right = new Node('H');

        tree.root.left.right.left = new Node('I');
        tree.root.left.right.right = new Node('J');

        tree.root.right.left.right = new Node('K');

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}