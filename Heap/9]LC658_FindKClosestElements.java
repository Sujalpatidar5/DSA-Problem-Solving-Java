/*
Problem: 658. Find K Closest Elements
Link: https://leetcode.com/problems/find-k-closest-elements/

-----------------------------------------------------

Problem Statement

Given a sorted array arr, two integers k and x,
return the k closest integers to x in the array.

If two numbers are equally close, prefer the smaller number.

Return result in sorted order.

-----------------------------------------------------

Pattern Used & Why

Pattern: Max Heap (Top K Elements)

Why:
- Maintain k closest elements
- Remove farthest element when size exceeds k
- Efficient: O(n log k)

-----------------------------------------------------

Key Idea

1. Calculate distance = |arr[i] - x|
2. Use max heap:
   - Larger distance = higher priority (remove first)
   - If tie → larger number remove first
3. Keep only k elements
4. Extract and sort

-----------------------------------------------------

Algorithm / Process

1. Create Pair (num, dist)
2. Create max heap:
      sort by dist DESC
      if equal → num DESC
3. Traverse array:
      add to heap
      if size > k → remove
4. Extract elements
5. Sort result

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    class Pair {
        int num;
        int dist;

        Pair(int n, int d){
            this.num = n;
            this.dist = d;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if (a.dist == b.dist) {
                    return b.num - a.num;
                }
                return b.dist - a.dist;
            }
        );

        for (int i = 0; i < arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            pq.add(new Pair(arr[i], dist));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().num);
        }

        Collections.sort(res);
        return res;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log k)

-----------------------------------------------------

Space Complexity
O(k)

-----------------------------------------------------

Example

Input:
arr = [1,2,3,4,5], k = 4, x = 3

Output:
[1,2,3,4]

-----------------------------------------------------

Explanation :

Use max heap to keep k closest elements.
Remove farthest based on distance.
Sort result before returning.
*/
