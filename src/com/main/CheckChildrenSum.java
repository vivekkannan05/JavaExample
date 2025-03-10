package com.main;

public class CheckChildrenSum {
    Node root;
    CheckChildrenSum(Node root){
        this.root=root;
    }

    public static void main(String[] args) {

        /*Node root = new Node(4);
        root.left=new Node(8);
        root.right= new Node(12);
        root.left.left = new Node(2);
        root.left.right=new Node(14);
        root.left.right.left = new Node(22);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(13);
        root.left.right.left.right = new Node(42);
        root.right.left= new Node(24);
        root.right.right= new Node(18);*/

        Node root = new Node(60);
        root.left=new Node(45);
        root.right= new Node(15);
        root.left.left = new Node(25);
        root.left.right=new Node(20);
        root.left.right.right=new Node(20);
        root.right.left= new Node(15);
        /*root.left.right.left = new Node(22);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(13);
        root.left.right.left.right = new Node(42);
        root.right.left= new Node(24);
        root.right.right= new Node(18);
*/
        System.out.println(checkChildrenSum(root));
    }

    private static boolean checkChildrenSum(Node root) {
        if(root==null||(root.left==null && root.right == null))
            return true;
        int sum =0;
        if(root.left !=null){
            sum += root.left.data;
        }
        if(root.right != null){
            sum +=root.right.data;
        }

        return root.data==sum && checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }

    static void printLeftNodesOnly(Node root){
        if(root==null){
            return;
        }

    }
}
