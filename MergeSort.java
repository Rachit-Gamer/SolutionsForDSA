import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] nums, int low, int mid, int high) {
        // Create a temporary array for merging
        int[] temp = new int[high - low + 1];

        int i = 0; // Index for temporary array
        int left = low; // Index for the left subarray
        int right = mid + 1; // Index for the right subarray

        // Merge the two halves into temp array
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[i++] = nums[left++];
            } else {
                temp[i++] = nums[right++];
            }
        }

        // Copy remaining elements from left subarray, if any
        while (left <= mid) {
            temp[i++] = nums[left++];
        }

        // Copy remaining elements from right subarray, if any
        while (right <= high) {
            temp[i++] = nums[right++];
        }

        // Copy merged elements from temp back to nums array
        for (int j = 0; j < temp.length; j++) {
            nums[low + j] = temp[j];
        }
    }

    public static void MS(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MS(nums, low, mid); // Sort left half
            MS(nums, mid + 1, high); // Sort right half
            merge(nums, low, mid, high); // Merge sorted halves
        }
    }

    public static void MergeSort(int[] nums) {
        MS(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        MergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
