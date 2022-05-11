package com.main.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read each object from the stream and returns stream of object
 */
public class JavaStreamFlatMapExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println(
            "==============================FlatMap example with Integer================================================================");
        // map example
        list.stream()
            .map(n->n+10)
            .forEach(System.out::println);

        //flatMap
        List<Integer> list1= Arrays.asList(1,2);
        List<Integer> list2= Arrays.asList(3,4);
        List<Integer> list3= Arrays.asList(5,6);

        List<List<Integer>> completeList = Arrays.asList(list1,list2,list3);

        List<Integer> finalList = completeList.stream()
            .flatMap(l -> l.stream())
            .collect(Collectors.toList());

        System.out.println(finalList);

        System.out.println(
            "========================================Flat Map with List<List<String>>======================================================");

        List<String> nameList1 = Arrays.asList("Vivek", "Kannan");
        List<String> nameList2 = Arrays.asList("Joe", "Zee");
        List<String> nameList3 = Arrays.asList( "Ria", "Sia");

        List<List<String>> clist = Arrays.asList(nameList1,nameList3,nameList2);

        System.out.println(clist.stream()
                                .flatMap(l -> l.stream())
                                .collect(Collectors.toList()));


        System.out.println(
            "==========================Flat Map With Class and Objects====================================================================");

        List<Employee> employees1 =
            Arrays.asList(  new Employee(1, "Vivek", "Dublin", 2500),
                            new Employee(2, "Kannan", "Amsterdam", 3500)
                          );

        List<Employee> employees2 =
            Arrays.asList(  new Employee(3, "Joe", "Paris", 1500),
                            new Employee(4, "Ria", "London", 1250)
                            );

        List<Employee> employees3 =
            Arrays.asList(new Employee(5, "Zee", "Paris", 5000),
                          new Employee(6, "Chi", "Tokyo", 6000)
                        );

        List<List<Employee>> employeeList = Arrays.asList(employees1,employees2,employees3);

        System.out.println(
        employeeList.stream()
                    .flatMap(el -> el.stream())
                    .map(e->e.getName())
                    .collect(Collectors.toList()));




    }
}


