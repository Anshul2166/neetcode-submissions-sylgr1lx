# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import collections

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root is None:
            return []

        queue = collections.deque()
        queue.append(root)

        bfs_list = []

        while queue:
            current_list = []
            len_queue = len(queue)

            for i in range(len_queue):
                current_node = queue.popleft()

                # Add element to current level node list
                current_list.append(current_node)
                
                # If left element for current node exists, add that to queue
                if current_node.left:
                    queue.append(current_node.left)

                # If right element for current node exists, add that to queue
                if current_node.right:
                    queue.append(current_node.right)
            
            # Add the current level list to bfs_list
            bfs_list.append(current_list)
        
        answer = []

        for level_list in bfs_list:
            # Add last element of list to answer
            answer.append(level_list[-1].val)
        
        return answer

        