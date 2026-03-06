/*
LeetCode 986 - Interval List Intersections

Problem Statement:
You are given two lists of closed intervals:

firstList  = [[start1, end1], [start2, end2], ...]
secondList = [[start1, end1], [start2, end2], ...]

Each interval list is sorted and non-overlapping.

Return the intersection of these two interval lists.

---------------------------------------

Pattern Used:
Intervals + Two Pointers

Why this pattern?

Both lists are already sorted by start time.

So we can traverse both lists simultaneously
using two pointers and find overlapping intervals.

---------------------------------------

Key Idea:

For two intervals:

[start1, end1]
[start2, end2]

Intersection range:

start = max(start1, start2)
end   = min(end1, end2)

If start <= end
→ valid intersection exists.

---------------------------------------

Approach:

1. Use two pointers:
   i for firstList
   j for secondList

2. Compare intervals.

3. Find intersection range.

4. If overlap exists
   add it to result.

5. Move the interval
   which ends first.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int n = firstList.length;
        int m = secondList.length;

        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {

            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // find intersection range
            int s = Math.max(start1, start2);
            int e = Math.min(end1, end2);

            // if valid overlap
            if (s <= e) {
                result.add(new int[]{s, e});
            }

            // move the interval which ends first
            if (end1 < end2) {
                i++;
            } 
            else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

/*
---------------------------------------

Example:

Input:
firstList  = [[0,2],[5,10],[13,23],[24,25]]
secondList = [[1,5],[8,12],[15,24],[25,26]]

Output:
[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

---------------------------------------

Time Complexity:

O(n + m)

We traverse both lists once.

---------------------------------------

Space Complexity:

O(k)

Where k = number of intersections.

---------------------------------------

Explanation :

"I used two pointers for both interval lists.
For each pair of intervals, I calculated the
intersection using max(start) and min(end).

If overlap existed, I added it to result.

Then I moved the pointer of the interval
which ended first."

---------------------------------------
*/
