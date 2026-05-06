/*
========================================
Problem: BFS of Graph (GFG)
========================================

Problem Statement:
Given an adjacency list of a graph, return the BFS traversal starting from node 0.

----------------------------------------
Pattern Used & Why:
Graph Traversal → Breadth First Search (BFS)

- BFS is used when:
  → Level order traversal required
  → Shortest path in unweighted graph
  → Explore neighbors first

----------------------------------------
Key Idea:
- Use Queue (FIFO)
- Start from node 0
- Visit node → push its neighbors
- Avoid revisiting using visited array

----------------------------------------
Algorithm / Process:

1. Create visited[] array
2. Create Queue
3. Add starting node (0)
4. While queue not empty:
     - Remove node
     - If not visited:
          → mark visited
          → add to result
          → push all unvisited neighbors
5. Return result

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();  

        ArrayList<Integer> result = new ArrayList<>();
        boolean vis[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(0); // start from node 0

        while (!q.isEmpty()) {

            int curr = q.remove();

            if (!vis[curr]) {

                vis[curr] = true;
                result.add(curr);

                for (int i = 0; i < adj.get(curr).size(); i++) {
                    int neighbor = adj.get(curr).get(i);

                    if (!vis[neighbor]) {
                        q.add(neighbor);
                    }
                }
            }
        }

        return result;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(V + E)
- Each node visited once
- Each edge processed once

Space Complexity:
O(V)
- visited array + queue

----------------------------------------
Example:

Adj List:
0 -> [1,2]
1 -> [0,3]
2 -> [0]
3 -> [1]

BFS Traversal:
[0,1,2,3]

----------------------------------------
Dry Run (Important):

Start:
q = [0]
vis = [F,F,F,F]

Step 1:
curr = 0
vis[0] = true
result = [0]
push neighbors → 1,2

q = [1,2]

Step 2:
curr = 1
vis[1] = true
result = [0,1]
push → 3

q = [2,3]

Step 3:
curr = 2
vis[2] = true
result = [0,1,2]

q = [3]

Step 4:
curr = 3
vis[3] = true
result = [0,1,2,3]

----------------------------------------
Explanation :

BFS me hum queue use karte hain.

- Start node 0 ko queue me daala
- Har step pe:
   → node nikala
   → agar visit nahi hua:
        mark visited
        result me add
        uske neighbors queue me daal diye

Isme level-wise traversal hota hai.

----------------------------------------
*/
