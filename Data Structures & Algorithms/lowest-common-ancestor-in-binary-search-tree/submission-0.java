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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minValue = Math.min(p.val, q.val);
        int maxValue = Math.max(p.val, q.val);

        while(true){
            int valRoot = root.val;
            if(valRoot > maxValue){
                root = root.left;
            }else if(valRoot < minValue){
                root = root.right;
            }else{
                return root;
            }
        }
    }
}
