import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // Partition the array into two halves
            int pivotIndex = partition(nums, low, high);

            // Recursively sort the subarrays
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        // Choose the pivot (middle element)
        int pivot = nums[(low + high) / 2];

        // Initialize pointers for partitioning
        int left = low;
        int right = high;

        while (left <= right) {
            // Find element on left that should be on right
            while (nums[left] < pivot) {
                left++;
            }
            // Find element on right that should be on left
            while (nums[right] > pivot) {
                right--;
            }
            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        // Return the pivot index
        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

