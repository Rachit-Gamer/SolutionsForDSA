import java.util.ArrayList;

public class SearchASorted2DMatrix {
    static ArrayList<Integer> binarySearch(int low, int high, int[][] matrix, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix[0].length;

        if (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                ans.add(row);
                ans.add(col);
                return ans; // Return immediately if target is found
            } else if (matrix[row][col] < target) {
                // Search in the right half
                return binarySearch(mid + 1, high, matrix, target);
            } else {
                // Search in the left half
                return binarySearch(low, mid - 1, matrix, target);
            }
        }

        return ans; // Return empty list if target is not found
    }

    static ArrayList<Integer> SearchMatrix(int[][] matrix, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n * m - 1;

        return binarySearch(low, high, matrix, target);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int target = 3;
        int matrix[][] = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        ArrayList<Integer> result = SearchMatrix(matrix, target);

        if (!result.isEmpty()) {
            int row = result.get(0);
            int col = result.get(1);
            System.out.println("Element " + target + " found at position: (" + row + ", " + col + ")");
        } else {
            System.out.println("Element " + target + " not found in the matrix.");
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }
}
