package com.main.leetcode;

import java.util.Date;

public class FibonacciSolution {

    private static long[] fibnocciMem;
    public static void main(String[] args) {


        int n = 50;
        fibnocciMem= new long[n+1];
        System.out.println("Start time" + new Date());
        long result = fibonacciFast(n);

        System.out.println(result);
        System.out.println("End Time "+new Date() );
    }

    /**
     * Recurssive algorithm this method is nice, but time consuming as it has to performm the same operation for every single recurssion
     * @param n
     * @return
     */

    private static long fibonacci(int n) {
        if(n<=1){
            return n;
        }
        return(fibonacci(n-1)+fibonacci(n-2));

    }

    /**
     * Fast algorithm or caching stratergy
     * @param n
     * @return result
     */

    private static long fibonacciFast(int n){

        if(n<=1){
            return n;
        }

        if(fibnocciMem[n] != 0){
            return fibnocciMem[n];
        }

        long nthValue = fibonacciFast(n-1)+fibonacciFast(n-2);
        fibnocciMem[n]=nthValue;
        return nthValue;

    }
}
