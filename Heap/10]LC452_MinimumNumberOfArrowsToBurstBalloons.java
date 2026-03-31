/*
Problem: 452. Minimum Number of Arrows to Burst Balloons
Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

-----------------------------------------------------

Problem Statement

You are given an array of balloons where each balloon is
represented as [start, end].

An arrow can be shot at any position x, and it will burst
all balloons where start <= x <= end.

Return the minimum number of arrows required to burst all balloons.

-----------------------------------------------------

Pattern Used & Why

Pattern: Greedy + Interval Scheduling

Why:
- Sort by end
- Always place arrow at the end of interval
- Maximize number of balloons burst with one arrow

-----------------------------------------------------

Key Idea

1. Sort balloons by ending point
2. Place arrow at end of first balloon
3. If next balloon overlaps → continue
4. If not → need new arrow

-----------------------------------------------------

Algorithm / Process

1. Sort intervals by end
2. arrows = 1
3. arrowPos = end of first interval
4. Traverse:
      if start > arrowPos:
          arrows++
          arrowPos = current end
5. Return arrows

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            int start = points[i][0];

            if (start > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log n)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

-----------------------------------------------------

Explanation :

Sort intervals by end.
Place arrow at end.
Reuse arrow for overlapping intervals.
If no overlap → new arrow.
*/
