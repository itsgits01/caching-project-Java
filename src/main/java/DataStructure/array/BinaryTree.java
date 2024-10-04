package DataStructure.array;

class BinaryTree {

    // Node class representing each element of the tree
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of the binary tree
    Node root;

    // Constructor to initialize the tree
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new key into the tree
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key into the tree
    private Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the unchanged root node
        return root;
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search for a key
    private boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Key is greater than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is smaller than root's key
        return searchRec(root.right, key);
    }

    // In-order traversal of the binary tree
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal of the binary tree
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal of the binary tree
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method to test the functionality of the BinaryTree class
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert keys into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print traversals of the tree
        System.out.println("In-order traversal:");
        tree.inorder();

        System.out.println("Pre-order traversal:");
        tree.preorder();

        System.out.println("Post-order traversal:");
        tree.postorder();

        // Search for keys in the tree
        int keyToSearch = 40;
        System.out.println("Search key " + keyToSearch + ": " + (tree.search(keyToSearch) ? "Found" : "Not Found"));

        keyToSearch = 90;
        System.out.println("Search key " + keyToSearch + ": " + (tree.search(keyToSearch) ? "Found" : "Not Found"));
    }
}
