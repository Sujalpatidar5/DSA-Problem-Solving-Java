/*
========================================
Problem: DFS of Graph (GFG) - Iterative
========================================

Problem Statement:
Given an adjacency list of a graph, return the DFS traversal starting from node 0
using STACK (iterative approach).

----------------------------------------
Pattern Used & Why:
Graph Traversal → DFS using Stack

- Same as recursion but:
  → We use explicit Stack instead of call stack
  → Helps avoid recursion limits
  → Interview me puchte hain difference

----------------------------------------
Key Idea:
- Stack = LIFO (Last In First Out)
- Push node → explore → go deep
- Reverse push important hai (order maintain karne ke liye)

----------------------------------------
Algorithm / Process:

1. Create visited[] array
2. Create Stack
3. Push starting node (0)
4. While stack not empty:
     - Pop node
     - If not visited:
          → mark visited
          → add to result
          → push neighbors in reverse order
5. Return result

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();
        boolean vis[] = new boolean[V];

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        st.push(0);

        while (!st.isEmpty()) {

            int curr = st.pop();

            if (!vis[curr]) {
                vis[curr] = true;
                result.add(curr);

                // reverse order (important)
                for (int i = adj.get(curr).size() - 1; i >= 0; i--) {
                    int neighbor = adj.get(curr).get(i);

                    if (!vis[neighbor]) {
                        st.push(neighbor);
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

Space Complexity:
O(V)
- visited + stack

----------------------------------------
Example:

Adj List:
0 -> [1,2]
1 -> [0,3]
2 -> [0]
3 -> [1]

DFS Traversal:
[0,1,3,2]

----------------------------------------
Dry Run (Important):

Start:
st = [0]

Step 1:
pop 0 → visit
result = [0]
push (2,1) ← reverse push

st = [2,1]

Step 2:
pop 1 → visit
result = [0,1]
push (3)

st = [2,3]

Step 3:
pop 3 → visit
result = [0,1,3]

st = [2]

Step 4:
pop 2 → visit
result = [0,1,3,2]

----------------------------------------
Explanation :

DFS stack me:
- stack me node push karte hain
- pop karke visit karte hain
- fir neighbors push karte hain

 Important:
Reverse order me push karna hota hai
tabhi traversal recursion jaisa dikhega

----------------------------------------
Recursion vs Stack:

Recursion:
- System stack use hota hai
- Code chhota

Stack:
- Manual control
- Interview me important

----------------------------------------
Short Comment (for code memory):

// stack → pop → visit → push neighbors (reverse)
*/
