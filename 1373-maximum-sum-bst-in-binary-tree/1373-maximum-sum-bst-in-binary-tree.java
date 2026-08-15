/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        // Post-order traversal: Left -> Right -> Node
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Check if subtree rooted at current node is a valid BST
        // left[1] is left subtree's max value
        // right[0] is right subtree's min value
        if (root.val > left[1] && root.val < right[0]) {
            int currentSum = left[2] + right[2] + root.val;
            maxSum = Math.max(maxSum, currentSum);

            int minVal = Math.min(root.val, left[0]);
            int maxVal = Math.max(root.val, right[1]);

            return new int[] { minVal, maxVal, currentSum };
        }

        // If not a valid BST, pass invalid range up so parents also fail
        int maxChildSum = Math.max(left[2], right[2]);
        return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, maxChildSum };
    }
}