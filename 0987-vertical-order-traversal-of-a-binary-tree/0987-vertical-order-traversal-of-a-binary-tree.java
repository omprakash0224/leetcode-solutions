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
    private TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        map = new TreeMap<>();

        // DFS Traversal to populate nested TreeMaps
        dfs(root, 0, 0);

        // Process outer TreeMap (Column wise)
        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> colList = new ArrayList<>();

            // Process inner TreeMap (Level wise)
            for (List<Integer> nodesList : levelMap.values()) {
                // Same cell elements must be sorted by value
                Collections.sort(nodesList);
                colList.addAll(nodesList);
            }

            result.add(colList);
        }

        return result;
    }
    private void dfs(TreeNode node, int col, int level) {
        if (node == null) return;

        // If column doesn't exist, create it
        map.putIfAbsent(col, new TreeMap<>());

        // If level doesn't exist under this column, create it
        map.get(col).putIfAbsent(level, new ArrayList<>());

        // Add current node value
        map.get(col).get(level).add(node.val);

        // Recursive DFS calls
        dfs(node.left, col - 1, level + 1);
        dfs(node.right, col + 1, level + 1);
    }
}