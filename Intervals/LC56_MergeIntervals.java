/*
LeetCode 56 - Merge Intervals

Problem Statement:
Given an array of intervals where intervals[i] = [start, end],
merge all overlapping intervals and return an array
of the non-overlapping intervals that cover all intervals.

---------------------------------------

Pattern Used:
Interval Pattern (Sorting + Linear Traversal)

Why this pattern?
- Problem contains ranges.
- We need to merge overlapping intervals.
- Sorting helps to bring overlapping intervals together.

---------------------------------------

Key Observation:

Two intervals overlap if:

current.start <= previous.end

If overlap:
    Merge them.
Else:
    Store previous interval.

---------------------------------------

Approach:

1. Sort intervals by start time.
2. Track current interval using start and end.
3. Traverse remaining intervals:
   - If overlapping -> extend end.
   - If not overlapping -> store previous interval and reset.
4. Add last interval to result.
5. Convert list to 2D array and return.

---------------------------------------

Time Complexity:
O(n log n)  → Sorting
O(n)        → Traversal

Space Complexity:
O(n)

---------------------------------------
*/

import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) return intervals;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Initialize first interval
        int start = intervals[0][0];
        int end   = intervals[0][1];

        // Step 3: Traverse intervals
        for (int i = 1; i < n; i++) {

            int s = intervals[i][0];
            int e = intervals[i][1];

            // Overlap condition
            if (end >= s) {
                end = Math.max(end, e);
            } 
            else {
                // Store previous interval
                result.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        // Convert List to 2D array
        return result.toArray(new int[result.size()][]);
    }
}

/*
---------------------------------------

Example:

Input:
[[1,3],[2,6],[8,10],[15,18]]

Output:
[[1,6],[8,10],[15,18]]

---------------------------------------

Explanation :

"I sorted the intervals by start time.
Then I compared each interval with the previous one.
If they overlapped, I merged them.
Otherwise, I stored the previous interval
and continued."

---------------------------------------
*/
