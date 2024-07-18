public class MaxHeightInBinaryTree
{
    public static int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int maxHeight = 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
        return maxHeight;
    }
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
        long endTime = System.nanoTime();
        System.out.println("Total time taken by the algorithm" + " " +(endTime - startTime) + " nanoseconds");
    }
}
