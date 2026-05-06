/*
========================================
Problem: DFS of Graph (GFG)
========================================

Problem Statement:
Given an adjacency list of a graph, return the DFS traversal starting from node 0.

----------------------------------------
Pattern Used & Why:
Graph Traversal → Depth First Search (DFS)

- DFS is used when:
  → Explore deeply (go as far as possible first)
  → Backtracking problems
  → Connected components
  → Cycle detection

----------------------------------------
Key Idea:
- Use Recursion (Implicit Stack)
- Visit node → go to its first unvisited neighbor → keep going deep
- Backtrack when no more neighbors

----------------------------------------
Algorithm / Process:

1. Create visited[] array
2. Create result list
3. Call dfs(0)
4. In dfs(node):
     → mark visited
     → add to result
     → for each neighbor:
           if not visited → dfs(neighbor)

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();
        boolean vis[] = new boolean[V];

        ArrayList<Integer> result = new ArrayList<>();

        dfs(0, adj, vis, result);

        return result;
    }

    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj,
                    boolean vis[], ArrayList<Integer> result) {

        vis[curr] = true;
        result.add(curr);

        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neighbor = adj.get(curr).get(i);

            if (!vis[neighbor]) {
                dfs(neighbor, adj, vis, result);
            }
        }
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(V + E)
- Each node visited once
- Each edge explored once

Space Complexity:
O(V)
- visited array + recursion stack

----------------------------------------
Example:

Adj List:
0 -> [1,2]
1 -> [0,3]
2 -> [0]
3 -> [1]

DFS Traversal (one possible):
[0,1,3,2]

----------------------------------------
Dry Run (Important 🔥):

Start:
dfs(0)

Step 1:
visit 0 → result = [0]
go to 1

Step 2:
visit 1 → result = [0,1]
go to 3

Step 3:
visit 3 → result = [0,1,3]
no unvisited → backtrack

Back to 1 → done
Back to 0 → go to 2

Step 4:
visit 2 → result = [0,1,3,2]

----------------------------------------
Explanation :

DFS me hum recursion use karte hain.

- Node visit karo
- Uska pehla unvisited neighbor pakdo
- Deep jao (recursive call)
- Jab end aa jaye → wapas aao (backtrack)

Ye depth-wise traversal hai (line me jaata hai).

----------------------------------------
Short Comment (for code memory):

// visit → go deep → backtrack → repeat
*/
