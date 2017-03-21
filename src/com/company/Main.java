package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    /*
        Functional Interfaces
        foreach    :    Consumer Interface
        map        :    Function Interface
        filter     :    Predicate Interface
        reduce     :    BinaryOperator( extends BiFunction ) Interface
     */

    public static void main(String[] args) {

        /*
            Creating an ArrayList
         */

        ArrayList<Integer> al = new ArrayList();

        // Adding elements to the ArrayList
        for (int i = -3; i < 4; i++) {
            al.add(i);
        }

        /*
            Objective : To print the original ArrayList
         */
        System.out.println("Printing the original ArrayList");
        System.out.print(al);

        System.out.println("\n\n" + "Printing the ArrayList using foreach loop");
        al.forEach(i -> System.out.print(i + " "));

        /*
            Objective  : To demonstrate the use of map funtion
         */
        System.out.println("\n\nUsing the map() to multiply each number by 2");
        al.stream().map(i -> i * 2).forEach(i -> System.out.print(i + " "));

        /*
            Objective : To demonstrate the use of filter function
         */
        System.out.println("\n\nUsing the filter() to filter out the negative numbers and zero");
        al.stream().filter(i -> i > 0).forEach(i -> System.out.print(i + " "));

        /*
            Objective : To demonstrate the use of reduce function
         */
        System.out.println("\n\nUsing the reduce() to find the sum of elements");
        System.out.println(al.stream().filter(i -> i >= 0).reduce(0, (sum, i) -> sum + i));

        /*
            Objective   : To demonstrate the lazy evaluation

            Explanation : Here the filter method sees that its result is not being used anywhere,
                          hence it does not evaluate it. This is called lazy evaluation.
                          Function such as map(),filter() are some of the lazy function in java 8.
                          Most of the terminal functions like reduce(),sum(),count() are the eager functions.
         */

        System.out.println("\n\nDemonstrating the use of lazy functions ( Without count() : Nothing is printed )");
        al.stream().filter(i -> {

            System.out.println("hello ");

            return i >= 0;
        });

        System.out.println("\n\nDemonstrating the use of lazy functions ( With count() : hello is printed multiple times ) ");
        al.stream().filter(i -> {

            System.out.print("hello ");

            return i >= 0;
        }).count();

        /*
            Objective : To demonstrate the findfirst function in Java 8
         */
        System.out.println("\n\nDemonstrating the find first function in java");
        al.stream().findFirst();

        /*
            Objective : To Demonstrate the construction of factorial function using Java 8
         */
        System.out.println("\n\nDemonstrating the factorial function using Java 8");
        System.out.print("5! = " + factorial(5));

        /*
            Objective : To Demonstrate the construction of isPrime function using Java 8
         */
        System.out.println("\n\nDemonstrating the isPrime function using Java 8");
        System.out.println("isPrime(5) = " + isPrime(5));

        /*
            Objective : To demonstrate the use of collector class in Java 8
         */

        System.out.println("Converting the stream to list using collect( Collectors.toList() )");

        List<Integer> positiveList;
        positiveList = al.stream().filter(i -> i > 0).collect(Collectors.toList());
        System.out.println(positiveList);

        /*
            Objective : To demonstrate the use of collect(Collectors.joining()) to join the elements of list
         */

        System.out.println("\n\nTo demonstrate the use of collect(Collectors.joining())");
        String str1 = al.stream().filter(i -> i > 0).map(i -> (i).toString()).collect(Collectors.joining());
        System.out.println(str1);

        /*
            Objective : To demonstrate the use of collect(Collector.joining(",")) to join the elements of the list
                        with a delimiter
         */

        System.out.println("\n\nTo demonstrate the use of collect(Collectors.joining(\"delim\")");
        String str2 = al.stream().filter(i -> i > 0).map(i -> (i).toString()).collect(Collectors.joining(","));
        System.out.println(str2);

    }

    /*
        Function to find the factorial, using java 8 constructs
     */

    private static int factorial(int num) {

        if (num < 0)
            return -1;
        else
            return IntStream.range(1, num + 1).reduce(1, (sum, i) -> sum * i);
    }


    /*
        Function to find whether the number is prime or not using java 8 constructs
     */

    private static boolean isPrime(int num) {

        if (num < 2)
            return false;
        else
            return IntStream.range(2, num).filter(i -> (num % i) == 0).count() == 0;

    }

}
