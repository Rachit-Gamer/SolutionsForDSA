import java.util.HashSet;
import java.util.Set;

public class ArraySubsetCheck {

    public static boolean isSubset(int[] arr1, int[] arr2) {
        // Convert arrays to sets
        Set<Integer> set1 = arrayToSet(arr1);
        Set<Integer> set2 = arrayToSet(arr2);

        // Check if set1 is a subset of set2
        return set2.containsAll(set1);
    }

    private static Set<Integer> arrayToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(isSubset(arr1, arr2));  // Output: true

        int[] arr3 = {5, 6, 7};
        int[] arr4 = {1, 2, 3, 4, 5};

        System.out.println(isSubset(arr3, arr4));  // Output: false
    }
}
