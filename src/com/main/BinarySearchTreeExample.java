package com.main;

public class BinarySearchTreeExample {
    Node root;
    public BinarySearchTreeExample(){
        root=null;
    }

    public static void main(String[] args) {

        BinarySearchTreeExample binarySearchTreeExample = new BinarySearchTreeExample();
        StringBuilder strBuilder = new StringBuilder();

        binarySearchTreeExample.insert(10);
        binarySearchTreeExample.insert(15);
        binarySearchTreeExample.insert(8);
        binarySearchTreeExample.insert(7);
        binarySearchTreeExample.insert(4);
        binarySearchTreeExample.insert(14);
        binarySearchTreeExample.insert(15);
        binarySearchTreeExample.insert(28);

       inOrderTraverse(binarySearchTreeExample.root,strBuilder);
        System.out.println(strBuilder.toString());
        strBuilder.delete(0,strBuilder.length());

       binarySearchTreeExample.delete(15);
       inOrderTraverse(binarySearchTreeExample.root,strBuilder);
        System.out.println(strBuilder.toString());
    }

    private void delete(int data) {
        root = delete(root,data);
    }

    private Node delete(Node root, int data) {
        if(root==null)
            return root;
        if(data < root.data){
            root.left=delete(root.left,data);
        }
        else if(data > root.data){
            root.right=delete(root.right,data);
        }else {
            if (root.left == null && root.right == null)
                return null;

            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            Node temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }
        return root;
    }

    private Node minValueNode(Node right) {
        Node curr = right;
        while(curr.left !=null){
            curr=curr.left;
        }
        return curr;
    }

    public static void inOrderTraverse(Node root, StringBuilder result) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, result);
        result.append(root.data).append(" ");
        inOrderTraverse(root.right, result);
    }

    public void insert(int key) {
        root = insert(root, key);
    }
     Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
              root.left= insert(root.left,data);
        }
        else
            root.right= insert(root.right,data);
        return root;

    }


}

