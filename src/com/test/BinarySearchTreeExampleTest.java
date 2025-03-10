/*
package com.test;

import com.main.BinarySearchTreeExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeExampleTest {

    */
/**
     * Test class for BinarySearchTreeExample.
     * It focuses on testing whether the insert method in the BinarySearchTreeExample class
     * correctly inserts elements into the binary search tree and maintains the BST properties.
     *//*


*/
/*    @Test
    void testInsertSingleElement() {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();
        bst.insert(10);

        StringBuilder result = new StringBuilder();
        bst.inOrderTraverse(bst.root, result);

        assertEquals("10 ", result.toString(), "The tree should contain the single inserted element 10.");
    }*//*


    @Test
    void testInsertMultipleElements() {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(8);

        StringBuilder result = new StringBuilder();
        BinarySearchTreeExample.inOrderTraverse(bst.root, result);

        assertEquals("5 8 10 20 ", result.toString(), "The tree should correctly contain and order the elements.");
    }

    @Test
    void testInsertDuplicateElement() {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();
        bst.insert(10);
        bst.insert(5);
        bst.insert(10); // Duplicate value

        StringBuilder result = new StringBuilder();
        BinarySearchTreeExample.inOrderTraverse(bst.root, result);

        assertEquals("5 10 ", result.toString(), "The tree should not include duplicate elements.");
    }

    @Test
    void testInsertWithNegativeValues() {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();
        bst.insert(5);
        bst.insert(-10);
        bst.insert(0);
        bst.insert(10);

        StringBuilder result = new StringBuilder();
        BinarySearchTreeExample.inOrderTraverse(bst.root, result);

        assertEquals("-10 0 5 10 ", result.toString(), "The tree should correctly handle and order negative and positive numbers.");
    }

    @Test
    void testInsertWithEmptyTree() {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();

        StringBuilder result = new StringBuilder();
        BinarySearchTreeExample.inOrderTraverse(bst.root, result);

        assertEquals("", result.toString(), "The tree should be empty initially.");
    }
}*/
