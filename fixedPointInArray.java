/*
Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array,
if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i.
Note that integers in array can be negative.

Examples:

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point
*/

import java.util.Scanner;
public class fixedPointInArray
{
    static int binarySearch(int low, int high, int arr[])
    {
        int mid = low + (high - low) / 2;
        if(mid== arr[mid])
            return mid;
        if(mid<arr[mid])
            return binarySearch(low, mid - 1, arr);
        else
            return binarySearch(mid + 1, high, arr);
    }
    static int fixedPoint(int arr[])
    {
        if(arr.length == 0)
            return -1;
        return binarySearch(0,arr.length-1,arr);
    }
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        int arr[] = {-10, -5, 0, 3, 7};
        System.out.println(fixedPoint(arr));
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }
}
