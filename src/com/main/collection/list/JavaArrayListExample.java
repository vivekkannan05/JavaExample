package com.main.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaArrayListExample {
    public static void main(String[] args) {
        addingElements();

    }



    static void addingElements(){

        /**
         * Adds all the data
         * Output: [A, C, null, B]
         */
        ArrayList<String> list = new ArrayList<String>();
        list.add(null);
        list.add(0, "A");
        list.add(2, "B");
        list.add(1, "C");
        System.out.println(list);

        /**
         * Creation a collection and adding at an index to another list
         * OUTPUT is [A,C,D,B]
         */
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        Collection<String> c = new ArrayList<>();
        c.add("C");
        c.add("D");
        list1.addAll(1, c);
        System.out.println(list1);

        /**
         * Throws index out of bound exception as we are trying to insert elements at index 3 whereas the size of the list is 2 at that given point
         */


        ArrayList<String> list2 = new ArrayList<String>();
            list2.add(null);
            list2.add(0, "A");
            list2.add(3, "B");
            list2.add(1, "C");
            System.out.println(list2);
           // list.


    }

}
