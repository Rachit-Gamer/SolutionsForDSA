public class MaxDifferenceDC {

    // Function to find maximum of two integers
    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // Function to find minimum of two integers
    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    // Function to find maximum difference in subarray crossing the midpoint
    private static int maxDifferenceCrossing(int[] nums, int low, int mid, int high) {
        // Find maximum element in left subarray ending at mid
        int maxLeft = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            maxLeft = max(maxLeft, nums[i]);
        }

        // Find minimum element in right subarray starting from mid+1
        int minRight = Integer.MAX_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            minRight = min(minRight, nums[i]);
        }

        // Return the difference
        return maxLeft - minRight;
    }

    // Function to find maximum difference in subarray using divide and conquer
    private static int maxDifferenceDC(int[] nums, int low, int high) {
        // Base case: Only one element
        if (low == high) {
            return 0; // If there's only one element, there's no difference
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;

        // Recursively find maximum difference in left and right halves
        int maxLeft = maxDifferenceDC(nums, low, mid);
        int maxRight = maxDifferenceDC(nums, mid + 1, high);

        // Find maximum difference in subarray crossing the midpoint
        int maxCross = maxDifferenceCrossing(nums, low, mid, high);

        // Return the maximum of the three differences
        return max(maxLeft, max(maxRight, maxCross));
    }

    // Wrapper function to call the divide and conquer approach
    public static int maxDifference(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }
        return maxDifferenceDC(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 1, 9, 5, 6, 4};
        int maxDiff = maxDifference(nums);
        System.out.println("Maximum difference between elements: " + maxDiff);
    }
}

