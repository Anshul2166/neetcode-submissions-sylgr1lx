class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:    
        adj = defaultdict(list)

        for node1, node2 in edges:
            adj[node1].append(node2)
            adj[node2].append(node1)

        visited = set()

        def dfs(i : int, prev : int):
            if i in visited:
                return False
            
            visited.add(i)
            for nei in adj[i]:
                if nei == prev:
                    continue
                if not dfs(nei, i):
                    return False
            return True
        
        return dfs(0, -1) and len(visited) == n
        