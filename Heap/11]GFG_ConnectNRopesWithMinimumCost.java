/*
Problem: Connect N Ropes with Minimum Cost (GFG)

-----------------------------------------------------

Problem Statement

Given n ropes of different lengths,
connect them into one rope.

Cost of connecting two ropes = sum of their lengths.

Return the minimum total cost to connect all ropes.

-----------------------------------------------------

Pattern Used & Why

Pattern: Min Heap (Greedy)

Why:
- Always connect smallest ropes first
- Minimizes total cost
- Classic greedy + heap problem

-----------------------------------------------------

Key Idea

1. Add all ropes into min heap
2. Take two smallest ropes
3. Connect them → cost = sum
4. Add back to heap
5. Repeat until one rope remains

-----------------------------------------------------

Algorithm / Process

1. Create min heap
2. Insert all rope lengths
3. While size > 1:
      - remove two smallest
      - cost += (a + b)
      - insert (a + b)
4. Return total cost

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    public int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all ropes
        for (int x : arr) {
            pq.add(x);
        }

        int cost = 0;

        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            cost += sum;

            pq.add(sum);
        }

        return cost;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log n)

-----------------------------------------------------

Space Complexity
O(n)

-----------------------------------------------------

Example

Input:
[4, 3, 2, 6]

Process:
2+3=5 → cost=5
5+4=9 → cost=14
9+6=15 → cost=29

Output:
29

-----------------------------------------------------

Explanation :

Use min heap.
Always combine two smallest ropes to minimize cost.
*/
