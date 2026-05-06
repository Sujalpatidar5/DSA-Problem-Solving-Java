/*
========================================
Problem: Find if Path Exists in Graph – LeetCode 1971
========================================

Problem Statement:
You are given:
- n nodes (0 to n-1)
- edges (undirected graph)
- source node
- destination node

Return true if there is a path from source to destination.

----------------------------------------
Pattern Used & Why:
Graph Traversal → DFS (using Stack)

Why:
- We need to check connectivity
- DFS helps explore all possible paths

----------------------------------------
Key Idea:
- Build graph using adjacency list
- Start from source
- Try to reach destination using DFS

----------------------------------------
Algorithm / Process:

1. Build adjacency list
2. Create visited array
3. Use stack → push source
4. While stack not empty:
     - pop node
     - if node == destination → return true
     - mark visited
     - push all unvisited neighbors
5. If traversal ends → return false

----------------------------------------
Code:
*/

import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Build graph (Adjacency List)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: DFS using Stack
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        st.push(source);

        while (!st.isEmpty()) {

            int curr = st.pop();

            if (curr == destination) return true;

            if (!vis[curr]) {
                vis[curr] = true;

                for (int i = 0; i < adj.get(curr).size(); i++) {
                    int neighbor = adj.get(curr).get(i);

                    if (!vis[neighbor]) {
                        st.push(neighbor);
                    }
                }
            }
        }

        return false;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(V + E)

Space Complexity:
O(V)

----------------------------------------
Example:

n = 3
edges = [[0,1], [1,2]]
source = 0
destination = 2

Path exists → 0 → 1 → 2 → TRUE

----------------------------------------
Explanation 

I first convert the given edges into an adjacency list.

This makes it easy to see which nodes are connected to each node.

Then I use DFS with a stack to explore the graph.

- I start from the source node and push it into the stack.

- Now I repeat:
    → take a node from the stack
    → check if it is the destination

- If yes:
    → I immediately return true
    → because path exists

- If not:
    → I mark this node as visited
    → so I don't visit it again

- Then I take all its neighbors
    → and push the unvisited ones into the stack

This process continues until:
- either I reach destination → return true
- or stack becomes empty → return false

So in simple words:
I explore all possible paths from source.
If I ever reach destination → path exists.

----------------------------------------
Short Comment (for code memory):

// build graph → DFS → if reach destination → true
*/
