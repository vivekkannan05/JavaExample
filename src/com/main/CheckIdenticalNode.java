package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckIdenticalNode {
    public static void main(String[] args) {

        Node root1 = new Node(4);
        root1.left=new Node(8);
        root1.right= new Node(12);
        root1.left.left = new Node(2);
        root1.left.right=new Node(14);
        root1.left.right.left = new Node(22);
        root1.left.right.right = new Node(10);
        root1.left.right.left.left = new Node(13);
        root1.left.right.left.right = new Node(42);
        root1.right.left= new Node(24);
        root1.right.right= new Node(18);




        Node root2 = new Node(4);
        root2.left=new Node(8);
        root2.right= new Node(12);
        root2.left.left = new Node(2);
        root2.left.right=new Node(14);
        root2.left.right.left = new Node(22);
        root2.left.right.right = new Node(10);
        root2.left.right.left.left = new Node(13);
        root2.left.right.left.right = new Node(42);
        root2.right.left= new Node(24);
        root2.right.right= new Node(18);


        System.out.println(inOrderTraversal(root1,root2));


    }
  static boolean inOrderTraversal(Node root1,Node root2){
        if(root1==null && root2==null)
        return true;
      if(root1==null || root2==null)
        return false;

       return (root1.data == root2.data) && inOrderTraversal(root1.left,root2.left) && inOrderTraversal(root1.right,root2.right);
    }
}
