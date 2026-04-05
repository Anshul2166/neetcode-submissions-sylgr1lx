class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visited = set()

        adj = defaultdict(list)
        for node1, node2 in edges:
            adj[node2].append(node1)
            adj[node1].append(node2)

        def dfs(i : int, prev : int) -> None:
            if i in visited:
                return
            
            visited.add(i)
            
            for nei in adj[i]:
                if nei == prev:
                    continue
                dfs(nei, i)
        
        current_component = 0

        for i in range(n):
            if i not in visited:
                dfs(i, -1)
                current_component += 1
         
        return current_component