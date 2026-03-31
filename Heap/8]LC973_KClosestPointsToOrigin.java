/*
Problem: 973. K Closest Points to Origin
Link: https://leetcode.com/problems/k-closest-points-to-origin/

-----------------------------------------------------

Problem Statement

Given an array of points where points[i] = [xi, yi],
return the k closest points to the origin (0, 0).

Distance = x^2 + y^2

-----------------------------------------------------

Pattern Used & Why

Pattern: Max Heap (size k)

Why:
- Maintain only k closest points
- Remove farthest when size exceeds k
- Efficient: O(n log k)

-----------------------------------------------------

Key Idea

1. Compute distance for each point
2. Use max heap (largest distance on top)
3. If size > k → remove farthest
4. Remaining elements = answer

-----------------------------------------------------

Algorithm / Process

1. Create Pair class (dist, x, y)
2. Create max heap based on dist
3. Traverse all points:
      add to heap
      if size > k → remove
4. Extract all points from heap

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    class Pair {
        int dist;
        int x;
        int y;

        Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        // Create a max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.dist - x.dist
        ); // largest distance on top

        // Traverse all points
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;

            pq.add(new Pair(dist, x, y));

            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Create result array
        int ans[][] = new int[k][2];

        // Remove from pq & add to ans
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }

        return ans;
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
points = [[1,3],[-2,2]], k = 1

Output:
[[-2,2]]

-----------------------------------------------------

Explanation :

Use max heap of size k.
Keep closest points and remove farthest.
*/
