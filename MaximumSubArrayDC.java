public class MaximumSubArrayDC {

    // Helper function to find maximum of three integers
    private static int maxOfThree(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    // Function to find maximum subarray sum crossing the midpoint
    private static int maxCrossingSubarray(int[] nums, int low, int mid, int high) {
        // Calculate maximum sum of left subarray ending at mid
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Calculate maximum sum of right subarray starting from mid+1
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return the maximum sum of subarray crossing the midpoint
        return leftSum + rightSum;
    }

    // Function to find maximum subarray sum using divide and conquer
    private static int maxSubarraySumDC(int[] nums, int low, int high) {
        // Base case: Only one element
        if (low == high) {
            return nums[low];
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;

        // Recursively find maximum subarray sum in left and right halves
        int maxLeft = maxSubarraySumDC(nums, low, mid);
        int maxRight = maxSubarraySumDC(nums, mid + 1, high);

        // Find maximum subarray sum crossing the midpoint
        int maxCross = maxCrossingSubarray(nums, low, mid, high);

        // Return the maximum of the three sums
        return maxOfThree(maxLeft, maxRight, maxCross);
    }

    // Wrapper function to call the divide and conquer approach
    public static int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        return maxSubarraySumDC(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 3, -4, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum subarray sum: " + maxSum);
    }
}

