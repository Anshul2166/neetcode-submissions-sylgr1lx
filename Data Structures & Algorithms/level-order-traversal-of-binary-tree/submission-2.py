# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        queue = collections.deque()

        queue.append(root)
        results = []
        while queue:
            queue_len = len(queue)
            current_level_nodes = []
            
            for i in range(queue_len):
                current_node = queue.popleft()
                current_level_nodes.append(current_node.val)
                if current_node.left:
                    queue.append(current_node.left) 
                if current_node.right:
                    queue.append(current_node.right)  
            
            results.append(current_level_nodes)
        
        return results


        