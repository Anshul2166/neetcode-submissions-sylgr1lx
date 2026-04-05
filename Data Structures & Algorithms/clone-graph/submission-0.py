"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:

        def dfs(node : Optional['Node']) -> Optional['Node']:

            if node is None:
                return None

            if node in visited_nodes:
                return visited_nodes[node]

            copy_node = Node()
            copy_node.val = node.val

            copy_node.neighbors = []

            visited_nodes[node] = copy_node

            for neighbor_node in node.neighbors:
                copied_neighbor_node = dfs(neighbor_node)
                copy_node.neighbors.append(copied_neighbor_node)

            return copy_node
        
        visited_nodes = {}
        return dfs(node)
        