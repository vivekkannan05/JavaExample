package com.main.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Performs Transformation to the data preseent in the stream. One form to another or perform some acction on the data
 *
 */
public class JavaStreamMapExample {

    public static void main(String[] args) {

        List<String> vehicles = Arrays.asList("cycle","Bike","moped","car","truck","train","flight");

        System.out.println(
            "============================= UpperCase using Map =================================================================");

        vehicles.stream()
                .map(a->a.toUpperCase())
                .forEach(System.out::println);


        System.out.println(
            "================================length of all the parameters==============================================================");

        List<Integer> lengthList = vehicles.stream().map(vehicle -> vehicle.length()).toList();

        lengthList.forEach(System.out::println);

        System.out.println(
            "=================================square of the number =============================================================");

        List<Integer> numList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        numList.stream().map(n -> n*n).forEach(System.out::println);


        System.out.println(
            "======================Combination fo Filter and Map . Salary increment========================================================================");

        List<Employee> employees = Arrays.asList(   new Employee(1,"Vivek","Dublin",2500),
                                                    new Employee(2,"Kannan","Amsterdam",3500),
                                                    new Employee(3,"Joe","Paris",1500),
                                                    new Employee(4,"Ria","London",1250),
                                                    new Employee(5,"Zee","Paris",5000)
                                                    );

        employees.stream()
                    .filter(e->e.salary<=1500)
                    .map(employee -> changeEmployee(employee))
                    .forEach(System.out::println);



    }

    static Employee changeEmployee(Employee employee){
        employee.setSalary(employee.getSalary()*2);
        return employee;
    }


}

class Employee{
    int id;
    String name;
    String city;
    double salary;

    public Employee(int id, String name, String city, double salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", city='" + city + '\'' + ", salary='" + salary
            + '\'' + '}';
    }
}
