/*
Given a sorted and rotated array arr[] of n distinct elements, the task is to find the index of given target element in the array.
If target is not present in the array, return -1.

Example:

Input  : arr[] = {4, 5, 6, 7, 0, 1, 2}, target = 0
Output : 4

Input  : arr[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 3
Output : -1

Input : arr[] = {30, 40, 50, 10, 20}, target = 10
Output : 3

*/
import java.util.Scanner;
public class SearchInRotatedSortedArray
{
    static int binarySearch(int low, int high, int arr[], int x)
    {
        int mid = low + (high - low) / 2;
        if(arr[mid] == x)
        {
            return mid;
        }
        while(low<=high)
        {
            if(arr[low]<=arr[mid])
            {
                if(arr[low] <= x && x <= arr[mid])
                {
                    return binarySearch(low,mid-1,arr,x);
                }
                else
                {
                    return binarySearch(mid+1,high,arr,x);
                }
            }
            else
            {
                if(arr[low] <= x && x <= arr[mid])
                {
                    return binarySearch(mid+1,high,arr,x);
                }
                else
                {
                    return binarySearch(low,mid-1,arr,x);
                }
            }
        }
        return -1;
    }
    static int SearchInRotatedSortedArr(int arr[], int n, int x)
    {
        return binarySearch(0,n,arr,x);
    }
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        //test case 1
        int arr[] = {30, 40, 50, 10, 20};
        int n = arr.length;
        int x = 10;
        System.out.println(SearchInRotatedSortedArr(arr,n,x));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for the algorithm to solve: " + (endTime - startTime) + " milliseconds");
    }
}
