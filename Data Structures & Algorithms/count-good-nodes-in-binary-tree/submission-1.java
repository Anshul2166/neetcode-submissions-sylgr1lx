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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return goodNodesCount(root, Integer.MIN_VALUE);
    }

    public int goodNodesCount(TreeNode root, int maxValueSeen){
        if(root == null)
            return 0;
        
        int count = 0;
        if(root.val >= maxValueSeen){
            count++;
        }

        maxValueSeen = Math.max(root.val, maxValueSeen);

        count += goodNodesCount(root.left, maxValueSeen);
        count += goodNodesCount(root.right, maxValueSeen);

        return count;
    }
}
