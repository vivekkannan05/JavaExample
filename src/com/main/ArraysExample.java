package com.main;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
getDistinctArray();
rotateArray();
rotateArraywithOptimisation();


int[] arr = {7,1,5,8,10,9,1,0};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

  Arrays.sort(arr);
    }

    /**
     * Processes an array of strings to remove duplicate entries and prints both the original
     * and the distinct arrays.
     *
     * This method demonstrates the usage of Java Streams by performing the following steps:
     * 1. Defines and initializes an array of strings, which may contain duplicate elements.
     * 2. Prints the original array to the console.
     * 3. Uses the `distinct` method provided by the Java Streams API to filter out duplicate elements
     *    and converts the resulting stream back to an array.
     * 4. Prints the distinct array to the console.
     *
     * Note:
     * - The method operates on a predefined hardcoded array of strings and is static, meaning it
     *   does not interact with instance-level data or accept parameters.
     * - The output is directly displayed on the console using `System.out.println`.
     */
    private static void getDistinctArray() {
        String[] arr = {"Karthi","Vivek","Suja","Karthi","Vivek","Suja"};
        System.out.println(Arrays.toString(arr));
        String[] distinct = Arrays.stream(arr).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(distinct));

    }

    /**
     * Rotates the elements of an array by a specified number of positions to the left.
     *
     * This method takes an array of integers and shifts each element by a number of positions
     * defined by the variable `m`. The rotation is performed using an iterative approach where
     * the first element is repeatedly moved to the end of the array, achieving the desired rotation.
     *
     * Steps:
     * 1. Loop through the rotation count (`m` modulo the length of the array).
     * 2. On each loop, shift elements to the left by moving the first element to the last position.
     * 3. Print the updated array after the rotation process is complete.
     *
     * Notes:
     * - The value of `m` is reduced by modulo `n` (length of the array) to handle cases where
     *   `m` exceeds the length of the array.
     * - The array is rotated left in-place with an additional loop to maintain ordering after each step.
     */
    public static void rotateArray(){
        int[] arr = {7,1,5,8,10,9,1,0};
        var m = 3;
        int val =Integer.MAX_VALUE;
        int n = arr.length;

        // i = i+m
        for (int i = 0; i <m%n; i++) {
            int first = arr[0];
            for(int j = 0; j < n-1; j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = first;
        }
        System.out.println(Arrays.toString(arr));


    }

    /*

    int[] arr = {7,1,5,8,10,9,1,0};
    var m = 3;
    step 1 reverse 0 -> m
        arr[] = {5,1,7,8,10,9,1,0}
    step 2 reverse m+1 -> n
        arr[]={5,1,7,0,1,9,10,8}

    Step 3 reverse 0-n
    arr[]={8,10,9,1,0,7,1,5}
,         */
    public static void rotateArraywithOptimisation(){
        int[] arr = {7,1,5,8,10,9,1,0};
        var m = 3;
        int val =Integer.MAX_VALUE;
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        twoPointerLogic(0,m, arr);
        twoPointerLogic(m,n, arr);
        twoPointerLogic(0,n, arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void twoPointerLogic(int m, int n, int[] arr) {
        int val;
        for (int i = m, j= n-1; i < j; i++,j--) {
            val = arr[i];
            arr[i]= arr[j] ;
            arr[j]=val;

        }
    }
//
//    private static void merges(int[] arr, int i, int mid, int n){
//        int n1=mid-i+1;
//        int n2=n-mid;
//
//        int[] temp1= new int[n1];
//        int[] temp2= new int[n2];
//        for(int j=0;j<n1;j++){
//            temp1[j]=arr[i+j];
//        }
//        for(int j=0;j<n2;j++){
//            temp2[j]=arr[mid+1+j];
//        }
//        int k=0;
//        int l=0;
//        int q=0;
//        while(k<n1 && l<n2){
//            if(temp1[k]<=temp2[l]){
//                arr[q++]=temp1[k];
//                k++;
//            }else{
//                arr[q++]=temp2[l];
//                l++;
//            }
//        }
//        for(int j=k;j<n1;j++){
//            arr[q++]=temp1[j];
//        }
//        for(int j=l;j<n2;j++){
//            arr[q++]=temp2[j];
//        }
//
//
//    }
    private static void merges(int[] arr, int i, int mid, int n) {
        // Calculate sizes of the two subarrays
        int n1 = mid - i + 1;
        int n2 = n - mid;

        // Create temporary arrays to store the data
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        // Copy data from original array to temp arrays
        for (int j = 0; j < n1; j++) {
            temp1[j] = arr[i + j];
        }
        for (int j = 0; j < n2; j++) {
            temp2[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays back into the original array
        int k = 0, l = 0;
        int q = i; // Start index for merging in the original array

        while (k < n1 && l < n2) {
            if (temp1[k] <= temp2[l]) {
                arr[q] = temp1[k];
                k++;
            } else {
                arr[q] = temp2[l];
                l++;
            }
            q++;
        }

        // Copy remaining elements of temp1[], if any
        while (k < n1) {
            arr[q] = temp1[k];
            k++;
            q++;
        }

        // Copy remaining elements of temp2[], if any
        while (l < n2) {
            arr[q] = temp2[l];
            l++;
            q++;
        }
    }
//
//    private static void mergeSort(int[] arr, int i, int n) {
//        // Validate the input
//        if (arr == null || arr.length == 0 || i >= n) {
//            return;
//        }
//
//        if (i < n) {
//            // Calculate the midpoint (adjusted formula for correct range)
//            int mid = i + (n - i) / 2;
//
//            // Sort the first and second halves recursively
//            mergeSort(arr, i, mid);
//            mergeSort(arr, mid + 1, n);
//
//            // Merge the sorted halves
//            merges(arr, i, mid, n);
//        }
//    }
    private static void mergeSort(int[] arr,int i,int n){
        if(i<n){
            int mid =i+(n-i)/2;
            mergeSort(arr,i,mid);
            mergeSort(arr,mid+1,n);
            merges(arr,i,mid,n);
        }
    }
    //create a method
    
}
