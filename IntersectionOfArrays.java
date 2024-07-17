import java.util.*;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};

        int[] intersection = findIntersection(arr1, arr2);

        // Print the intersection array
        System.out.print("Intersection of the two arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] findIntersection(int[] arr1, int[] arr2) {
        // Use HashSet for O(1) average time complexity for contains() operation
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add elements from arr1 to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Check elements of arr2 against set1
        for (int num : arr2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert resultSet to int array
        int[] intersection = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            intersection[index++] = num;
        }

        return intersection;
    }
}

