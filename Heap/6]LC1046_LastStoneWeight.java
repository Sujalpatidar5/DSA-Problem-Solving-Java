/*
Problem: 1046. Last Stone Weight
Link: https://leetcode.com/problems/last-stone-weight/

-----------------------------------------------------

Problem Statement

You are given an array of integers stones where stones[i]
is the weight of the i-th stone.

Each turn:
- Choose the two heaviest stones
- Smash them together

If:
- Equal → both destroyed
- Not equal → remaining = difference

Return the weight of the last remaining stone.
If none remain → return 0.

-----------------------------------------------------

Pattern Used & Why

Pattern: Max Heap (Priority Queue)

Why:
We always need the two largest elements efficiently.

-----------------------------------------------------

Key Idea

1. Store all stones in max heap
2. Take top 2 largest stones
3. If unequal → insert difference
4. Repeat until ≤ 1 stone remains

-----------------------------------------------------

Algorithm / Process

1. Create max heap
2. Add all elements
3. While size > 1:
      remove top 2
      if not equal → add difference
4. Return remaining element or 0

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones
        for (int s : stones) {
            pq.add(s);
        }

        // Process until one or none left
        while (pq.size() > 1) {

            int first = pq.poll();   // largest
            int second = pq.poll();  // second largest

            if (first != second) {
                pq.add(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
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
stones = [2,7,4,1,8,1]

Output:
1

-----------------------------------------------------

Explanation :

Use max heap to always pick 2 largest stones.
Simulate smashing process until one or none remains.
*/
