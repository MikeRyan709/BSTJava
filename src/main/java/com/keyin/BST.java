package com.keyin;

public class BST {

    // defines BST node
    class Node {
        int value;
        Node left, right;

        public Node(int data){
            value = data;
            left = right = null;
        }
    }
    //root node
    static Node root;

    BST(){
        root = null;
    }

    //delete a node
     public void deleteValue(int value) {
        root = deleteRecursive(root, value);
    }

    //recursive delete function
    Node deleteRecursive(Node root, int value)  {
        if (root == null)  return root;

        //traverse the tree
        if (value < root.value) //traverse left
            root.left = deleteRecursive(root.left, value);
        else if (value > root.value) //traverse right
            root.right = deleteRecursive(root.right, value);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            root.value = minValue(root.right);

            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root)  {
        int minVal = root.value;
        while (root.left != null)  {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    // insert a node in BST
    void insert(int value)  {
        root = insertRecursive(root, value);
    }

    //recursive function
    Node insertRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insertRecursive(root.left, value);
        else if (value > root.value)
            root.right = insertRecursive(root.right, value);
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorderRecursive(root);
    }

    // recursively traverse the BST
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.value + " ");
            inorderRecursive(root.right);
        }
    }

    boolean search(int value)  {
        root = searchRecursive(root, value);
        return root != null;
    }

    Node searchRecursive(Node root, int value) {

        if (root==null || root.value ==value)
            return root;
        if (root.value > value)
            return searchRecursive(root.left, value);
        // value is less than root's value
        return searchRecursive(root.right, value);
    }
    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


}
