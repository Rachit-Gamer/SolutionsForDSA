public class MajorityElementDC {

    // Function to find the majority element in an array using divide and conquer
    private static Integer findMajorityElementDC(int[] nums, int low, int high) {
        // Base case: Single element
        if (low == high) {
            return nums[low];
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;

        // Recursively find majority elements in left and right halves
        Integer leftMajority = findMajorityElementDC(nums, low, mid);
        Integer rightMajority = findMajorityElementDC(nums, mid + 1, high);

        // If both halves have the same majority element, return it
        if (leftMajority != null && rightMajority != null && leftMajority.equals(rightMajority)) {
            return leftMajority;
        }

        // Count occurrences of left and right majority candidates
        int leftCount = countOccurrences(nums, low, high, leftMajority);
        int rightCount = countOccurrences(nums, low, high, rightMajority);

        // Determine the overall majority element
        if (leftCount > (high - low + 1) / 2) {
            return leftMajority;
        } else if (rightCount > (high - low + 1) / 2) {
            return rightMajority;
        } else {
            return null; // No majority element
        }
    }

    // Function to count occurrences of an element in a subarray
    private static int countOccurrences(int[] nums, int low, int high, Integer element) {
        if (element == null) {
            return 0;
        }
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == element) {
                count++;
            }
        }
        return count;
    }

    // Wrapper function to call the divide and conquer approach
    public static Integer findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return findMajorityElementDC(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Integer majorityElement = findMajorityElement(nums);
        if (majorityElement != null) {
            System.out.println("Majority element: " + majorityElement);
        } else {
            System.out.println("No majority element");
        }
    }
}
