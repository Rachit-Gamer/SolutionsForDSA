public class MaxMinDC {

    // Helper class to store both max and min
    static class Pair {
        int max;
        int min;

        Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    // Function to find maximum and minimum in an array using divide and conquer
    private static Pair maxMinDC(int[] nums, int low, int high) {
        // Base case: Only one element
        if (low == high) {
            return new Pair(nums[low], nums[low]);
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;

        // Recursively find maximum and minimum in left and right halves
        Pair leftPair = maxMinDC(nums, low, mid);
        Pair rightPair = maxMinDC(nums, mid + 1, high);

        // Combine results from left and right halves
        int overallMax = Math.max(leftPair.max, rightPair.max);
        int overallMin = Math.min(leftPair.min, rightPair.min);

        return new Pair(overallMax, overallMin);
    }

    // Wrapper function to call the divide and conquer approach
    public static Pair findMaxMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        return maxMinDC(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 1, 9, 5, 6, 4};
        Pair result = findMaxMin(nums);
        System.out.println("Maximum element: " + result.max);
        System.out.println("Minimum element: " + result.min);
    }
}
