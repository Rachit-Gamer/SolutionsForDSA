public class SegmentTree {

    private int[] segmentTree;
    private int[] nums;

    // Constructor to build segment tree
    public SegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        // Height of the segment tree (log2(n))
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        // Maximum size of the segment tree
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        segmentTree = new int[maxSize];
        buildSegmentTree(0, 0, n - 1);
    }

    // Recursive function to build segment tree
    private void buildSegmentTree(int pos, int low, int high) {
        if (low == high) {
            // Leaf node: store the value of nums[low]
            segmentTree[pos] = nums[low];
        } else {
            // Divide the range into two halves
            int mid = (low + high) / 2;
            // Build segment tree for left and right subtree
            buildSegmentTree(2 * pos + 1, low, mid);
            buildSegmentTree(2 * pos + 2, mid + 1, high);
            // Combine results from left and right subtree
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }
    }

    // Function to print the segment tree (for debugging)
    public void printSegmentTree() {
        System.out.print("Segment Tree: ");
        for (int i = 0; i < segmentTree.length; i++) {
            System.out.print(segmentTree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(nums);
        st.printSegmentTree();
    }
}
