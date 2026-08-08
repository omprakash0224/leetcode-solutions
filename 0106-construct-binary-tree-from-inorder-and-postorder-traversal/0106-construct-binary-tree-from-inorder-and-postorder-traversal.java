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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return treeBuilder(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);       
    }
    private TreeNode treeBuilder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        // Root is the last element in postorder
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        // Build left subtree
        root.left = treeBuilder(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inMap);

        // Build right subtree
        root.right = treeBuilder(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);

        return root;

    }
}