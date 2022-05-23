package com.main.algo;

public class AlgorithmExample {

    public static void main(String[] args) {

        System.out.println(findMaxNumber(1,2,3));
        System.out.println(findMaxNumber(16,27,83));
        System.out.println(findMaxNumber(81,2,43));
        System.out.println(findMaxNumber(551,62,1113));


    }

    static int findMaxNumber(int a, int b, int c){
        if(a>=b){
            if(a>=c)
                return a;
        }
        if(b>c)
            return b;

        return c;
    }

    static int findMaxNum(int a, int b, int c){

        int max =a;

        if (b>max)
            max=b;
        if(c>max)
            max=c;

        return max;
    }
}
