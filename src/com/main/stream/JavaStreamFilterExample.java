package com.main.stream;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaStreamFilterExample {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(
            "==============================for each and remove if================================================================");
        List<Integer> numList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
         numList.removeIf(a->a%2==0);
        numList.forEach(System.out::println);
        numList.removeIf(a->a==3);
        numList.forEach(System.out::println);


        System.out.println("==============================================================================================");

        //
        List<String> strList = List.of("foo", "bar", "test");
       // strList.add("bla");
       // strList.removeIf(a->a=="bar"); // This will throw Unsupprted Exception as it is Imutablw collection
        System.out.println(strList.size());

        System.out.println(
            "===================================Demo1 :Playing with filter===========================================================");



        List<Integer> evenList = intList.stream()
                                        .filter(a->a%2==0)
                                        .toList(); // immutable String
                                       // .collect(Collectors.toList());
        System.out.println(evenList);



        System.out.println(
            "=====================================Demo2 :Playing with filter with multiple condtion=========================================================");

        List<String> nameList = Arrays.asList("Vivek","Kannan","Joe","Zee","Ria","Sia");

        List<String> filteredNames = nameList.stream()
                .filter(name -> name.length()>3 && name.length()<6   )
                .toList();
        System.out.println(filteredNames);



        System.out.println(
            "================================FilterNull or Empty==============================================================");

        List<String> wordsList = Arrays.asList("foo", "bar",null, "test",null,"theatre","");
        //List<String> wordsList = List.of("foo", "bar",null, "test",null,"theatre"); // Will thow error as it does not accept Null object
        wordsList.stream()
                 .filter(word -> StringUtils.isNotBlank(word))
                 .forEach(System.out::println);


        System.out.println(
            "====================================Filter on Class Object==========================================================");

        List<Product> productList = Arrays.asList(  new Product(1,"HPLaptop",1000 ),
                                                    new Product(2,"DellLaptop",800 ),
                                                    new Product(3,"LenovoLaptop",4000 ),
                                                    new Product(4,"SonyLaptop",6000 ),
                                                    new Product(5,"AppleMac",10000 )
                                                 );

        productList.stream()
                    .filter(p->p.price>5000)
                    .forEach(System.out::println);


    }

}

class Product{
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }
}
