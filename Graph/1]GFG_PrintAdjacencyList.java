/*
========================================
Problem: Print Adjacency List (Graph)
========================================

Problem Statement:
Given number of vertices V and edges[][], create and return the adjacency list representation of the graph.

----------------------------------------
Pattern Used & Why:
Graph + Adjacency List

- We use adjacency list because:
  → Space efficient (O(V + E))
  → Easy traversal (BFS/DFS later)

----------------------------------------
Key Idea:
- Create V empty lists
- For every edge (u, v):
  → add v in u's list
  → add u in v's list (because undirected)

----------------------------------------
Algorithm / Process:

1. Create ArrayList<ArrayList<Integer>> adj
2. Initialize V empty lists
3. Traverse edges array:
     - Extract u and v
     - Add v to adj[u]
     - Add u to adj[v]
4. Return adj list

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public static ArrayList<ArrayList<Integer>> printGraph(int V, int edges[][]) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Step 2: Initialize empty lists for all vertices
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 3: Add edges (undirected graph)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(V + E)
- V → initializing list
- E → traversing edges

Space Complexity:
O(V + E)
- V lists + storing all edges

----------------------------------------
Example:

Input:
V = 3
edges = [[0,1], [1,2]]

Adjacency List:
0 -> [1]
1 -> [0,2]
2 -> [1]

----------------------------------------
Explanation :

I will create an adjacency list using ArrayList of ArrayList.

- First, I initialize V empty lists (one for each node)

- Then for every edge (u, v):
  → I add v into u’s list
  → I add u into v’s list (because graph is undirected)

- Finally, I return the adjacency list

----------------------------------------
*/
