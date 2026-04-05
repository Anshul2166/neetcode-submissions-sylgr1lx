# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        element_list = []

        if root is None:
            return -1

        def kthSmallestDfs(root : Optional[TreeNode]) -> None:
            if root is None:
                return 

            if len(element_list) >= k:
                return 
            
            # Iterate over left child elements
            kthSmallestDfs(root.left)

            element_list.append(root)

            if len(element_list) >= k:
                return 

            # Iterate over right child elements
            kthSmallestDfs(root.right)
        
        kthSmallestDfs(root)

        return element_list[k-1].val


        