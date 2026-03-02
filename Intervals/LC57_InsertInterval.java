/*
LeetCode 57 - Insert Interval

Problem Statement:
You are given a list of non-overlapping intervals sorted by start time.
Insert a new interval into the intervals and merge if necessary.

Return the updated list of intervals.

---------------------------------------

Pattern Used:
Interval Pattern (Sorting + Merging)

Why this pattern?
- Intervals are already sorted.
- We insert a new interval in correct position.
- Then we merge overlapping intervals (same logic as LC 56).

---------------------------------------

Key Idea:

Step 1 → Insert the new interval in correct sorted position.
Step 2 → Apply merge logic (like Merge Intervals problem).

---------------------------------------

Approach:

1. Create a new array of size n+1.
2. Insert the new interval at correct position.
3. Traverse and merge overlapping intervals.
4. Convert result list to 2D array and return.

---------------------------------------


import java.util.*;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int[][] arr = new int[n + 1][2];

        int j = 0;
        boolean inserted = false;

        // Step 1: Insert new interval in correct position
        for (int i = 0; i < n; i++) {

            if (!inserted && newInterval[0] < intervals[i][0]) {
                arr[j++] = newInterval;
                inserted = true;
            }

            arr[j++] = intervals[i];
        }

        // If new interval not inserted yet, add at end
        if (!inserted) {
            arr[j] = newInterval;
        }

        // Step 2: Merge intervals (same logic as LC 56)

        List<int[]> result = new ArrayList<>();

        int start = arr[0][0];
        int end   = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            int s = arr[i][0];
            int e = arr[i][1];

            // Overlapping condition
            if (s <= end) {
                end = Math.max(end, e);
            } 
            else {
                result.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)

---------------------------------------

Explanation :

"I first insert the new interval in sorted order.
Then I apply the standard merge intervals logic
to combine overlapping intervals."
*/
