package com.main.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExample {

    /**
     * Streams have 2 types of operation
     *              Terminal and Non Terminal
     *      Non terminal return a stream.
     *      ex: filter,flatmap,distinct
     *          map,limit
     *      Terminal Method
     *          ex: collect, count, min, max
     *              foreeach, toArray
     *
     *          Colections  --> Streams --> Non Terminal Operation --> Non terminal operation
     */

    public static void main(String[] args) {
        List<String> duplicateNameList = Arrays.asList("Vivek", "Kannan", "Joe", "Zee", "Ria", "Sia","Kannan", "Joe", "Zee");
        List<Integer> numList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println(
            "===================================distinct Method===========================================================");

        System.out.println(duplicateNameList.stream().distinct().collect(Collectors.toList()));

        System.out.println(
            "========================================distinct Method and count======================================================");
        System.out.println(duplicateNameList.stream().distinct().count());



        System.out.println(
            "====================================Limit meethod non terminal operation==========================================================");

        System.out.println(duplicateNameList.stream().limit(4).collect(Collectors.toList()));

        System.out.println(
            "=============================== count terminal operation ===============================================================");

        System.out.println(numList.stream()
                .filter(n->n%2==0)
                .count());

        System.out.println(
            "=================================Min and Max =============================================================");
        System.out.println(
                            numList.stream()
                             .min((val1, val2)->{return val1.compareTo(val2);})
                             .get());

        System.out.println(
                            numList.stream()
                                    .max((val3,val4)->{
                                        return val3.compareTo(val4);
                                     })
                                    .get()
                            );

        System.out.println(
            "=====================================reduce =========================================================");
        Optional<String> reduced =duplicateNameList.stream()
            .distinct().reduce((a,combinedValue)->{
                return combinedValue+a;
            });

        System.out.println(reduced.get());

        System.out.println(
            "======================================Sorted method========================================================");

        System.out.println(numList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        System.out.println(duplicateNameList.stream().distinct().sorted().collect(Collectors.toList()));

        System.out.println(
            "==============================Any Match all Match, None Match ================================================================");

        boolean result = duplicateNameList.stream()
                                        .anyMatch(val->val.endsWith("ia")); // any one elemeent in the stream should match

        System.out.println(result);

        result = duplicateNameList.stream().allMatch(val -> val.endsWith("ia")); // should mmatch all the elements in the stream

        System.out.println(result);

        result = duplicateNameList.stream().noneMatch(val-> val.endsWith("asd"));

        System.out.println(result);

        System.out.println(
            "=============================find first=================================================================");

        List<String> strList = Arrays.asList("bar", "test", "one","two","foo");

        Optional elem = strList.stream().findFirst();

        System.out.println(elem.get());



        System.out.println(
            "======================================find any========================================================");

       Optional ele = strList.stream().findAny();

        System.out.println(ele.get());

        System.out.println(
            "=============================Concatenation of Stream=================================================================");

        List<String> nameList = Arrays.asList("Vivek", "Kannan", "Joe", "Zee", "Ria", "Sia");

        Stream stream1 = nameList.stream();
        Stream stream2 = strList.stream();

        List<String> finalStreams = (List<String>) Stream.concat(stream1,stream2)
                                    .collect(Collectors.toList());

        System.out.println(finalStreams);

        System.out.println(""" 
            =====================================================================================================================
                  how take while works. It stop once the predicacte returns false. Returns elements till conodition fails
            #####################################################################################################################
            
            """);

        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        list.stream().takeWhile(i->i%5<3).forEach(System.out::println);

        System.out.println(""" 
                        =====================================================================================================================
                   How drop while works, It starts once the predicate returns false. Retirns elements after the condition fail. 
            #####################################################################################################################
                        """);

        list.stream().dropWhile(i->i%5<3).forEach(System.out::println);

        System.out.println(""" 
            =====================================================================================================================
                    Stream. ofNullable
            #####################################################################################################################
                       """);

        System.out.println(Stream.ofNullable(12).count());
        System.out.println(Stream.ofNullable(null).count());
        //System.out.println(Stream.of(null).count()); // null pointer exception

        System.out.println(""" 
            =====================================================================================================================
                    Peek on Stream. It does not do any changes. It will peek into the element but does not modified
                    Use when terminal operation is used
            #####################################################################################################################
            """);
                numList.stream().filter(i-> i>5).peek(i -> System.out.println(i)).collect(Collectors.toList());


        System.out.println(""" 
            =====================================================================================================================
                    Skip on Stream will skip the intial no of elements  till the number mentioned
             
            #####################################################################################################################
            """);
                         numList.stream().skip(5).limit(3).peek(i -> System.out.println(i)).collect(Collectors.toList());











    }

}
