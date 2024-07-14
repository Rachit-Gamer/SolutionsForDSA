/*Problem statement -
* Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).
*
* Test case 1
*   Input:
    x = 5
    Output: 2
    Explanation: Since, 5 is not a perfect
    square, floor of square_root of 5 is 2.

* Test case 2
* Input:
    x = 4
    Output: 2
    Explanation: Since, 4 is a perfect
    square, so its square root is 2.
*  */
package DataStructureAndAlgorithms;

import java.util.Scanner;

public class SquareRootOfInteger {

    public static int BinarySearch(int low, int high, int x)
    {
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        return BinarySearch(0,x,x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any random number: ");
        int x = sc.nextInt();
        sc.close(); // Close the scanner after reading input

        long startTime = System.currentTimeMillis();
        int result = sqrt(x);
        long endTime = System.currentTimeMillis();

        System.out.println("Answer to the question is " + result);
        System.out.println("Time taken for the algorithm to solve: " + (endTime - startTime) + " milliseconds");
    }
}


//before optimization the time complexity was almost 2370 ms to 3505 ms.
//After using extra variables the time complexity reduced to 0 ms. - because mid * mid calculation affected the performance of the code... due to square calculation and checking...
