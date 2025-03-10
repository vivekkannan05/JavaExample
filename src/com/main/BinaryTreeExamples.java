package com.main;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTreeExamples {

    public static void main(String[] args) {

//        Node root = new Node(12);
//        root.left=new Node(8);
//        root.right= new Node(18);
//        root.left.left = new Node(5);
//        root.left.right=new Node(11);

        Node root = new Node(4);
        root.left=new Node(8);
        root.right= new Node(12);
        root.left.left = new Node(2);
        root.left.right=new Node(14);
        root.left.right.left = new Node(22);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(13);
        root.left.right.left.right = new Node(42);
        root.right.left= new Node(24);
        root.right.right= new Node(18);



/*
        System.out.println("Output of Inorder Traversal");
        inOrderTraversal(root);

        System.out.println("Output of PreOrder Traversal");
        preOrderTraversal(root);

        System.out.println("Output of PostOrder Traversal");
        postOrderTraversal(root);

*/

/*
        System.out.println("Output of LevelOrder Travesal");
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        levelOrderTraversal(queue,arrayList);
        System.out.println(arrayList.size());
        int level =1;

        arrayList.forEach(integerArrayList->{
            System.out.println("==================================");
            System.out.println(integerArrayList.size());
            System.out.println("==================================");
            integerArrayList.forEach(System.out::println);});
*/

        System.out.println( findMaxHeightOfNode(root));

    }

    private static void postOrderTraversal(Node root) {
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    private static void preOrderTraversal(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if(root==null ){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    private static void levelOrderTraversal(Queue<Node> queue, ArrayList<ArrayList<Integer>> arrayList){
        /*
        check if root is null,
        Take the root element and add to queue
        pop the element from queue.
        add to a list
        print the node data
        check for the child element if present add to queue
        repeat the process
         */
        int level =0;
        while(!queue.isEmpty()) {
            System.out.println("=========================================");
            ArrayList<Integer> arrList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node root = queue.poll();
                if(root==null) {
                    return;
                }
                arrList.add(root.data);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }


            }
            arrayList.add(arrList);
          //  System.out.println("Level =" +level++);
            //System.out.println(arrayList);

        }

       // levelOrderTraversal(queue,arrayList);
    }

    public static int findMaxHeightOfNode(Node root){
        if(root==null)
            return 0;
        int leftCounter = findMaxHeightOfNode(root.left);
        int rightCounter = findMaxHeightOfNode(root.right);
        System.out.println("Data is "+root.data+" Left Counter "+leftCounter+" Right COunter "+rightCounter );
        return Math.max(leftCounter,rightCounter)+1;
    }
}

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
