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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
            
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int currLevelLength = 1, nextLevelLen = 0;

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            currList.add(curr.val);
            currLevelLength--;

            if(curr.left != null){
                queue.add(curr.left);
                nextLevelLen++;
            }
            if(curr.right != null){
                queue.add(curr.right);
                nextLevelLen++;
            }

            if(currLevelLength == 0){
                currLevelLength = nextLevelLen;
                nextLevelLen = 0;
                list.add(currList);
                currList = new ArrayList<>();
            }
        }

        return list;
    }
}
