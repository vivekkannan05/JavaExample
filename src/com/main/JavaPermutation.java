package com.main;

import java.util.Arrays;

public class JavaPermutation {


    static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
           // System.out.println(java.util.Arrays.toString(arr.toArray()));
           // int[] b = arr.toArray();
            printArr(arr.stream().mapToInt(Integer::intValue).toArray(),k);
        }
    }


    static void printArr(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Generating permutation using Heap Algorithm
    static int heapPermutation(int a[], int size, int n, int count)
    { int permCount =0;

        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(a, n);

        for (int i = 0; i < size; i++) {

            heapPermutation(a, size - 1, n,count);
            count++;
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
        //System.out.println(permCount);
        //System.out.println("Inside heap "+count);
        return count;
    }

    // Driver code
    public static void main(String args[])
    {
        JavaPermutation.permute(java.util.Arrays.asList(3,4,6), 0);

        var obj = new JavaPermutation();
        int a[] = { 1, 2, 3 };
        int count =0;
        System.out.println(JavaPermutation.heapPermutation(a, a.length, a.length,count));
        System.out.println(count);
    }
}
