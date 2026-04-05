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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        
        kthSmallestNode(root, k, list);
        return list.get(k-1).val;
    }

    public void kthSmallestNode(TreeNode root, int k, List<TreeNode> list){
        if(root == null){
            return;
        }
        
        kthSmallestNode(root.left, k, list);
        list.add(root);
        kthSmallestNode(root.right, k, list);

        if(list.size() >= k){
            return;
        }
    }
}
