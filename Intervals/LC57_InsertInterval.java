/*
LeetCode 57 - Insert Interval

Problem Statement:
You are given a list of non-overlapping intervals
sorted by their start time.

Insert a new interval into the list
and merge overlapping intervals if necessary.

Return the updated list of intervals.

---------------------------------------

Pattern Used:
Interval Pattern (Insert + Merge)

Why this pattern?
- Intervals are already sorted.
- After inserting the new interval,
  overlapping intervals must be merged.
- Same merging logic as Merge Intervals (LC 56).

---------------------------------------

Key Observation:
- First, place the new interval
  in the correct sorted position.
- Then traverse the array:
  - If intervals overlap → merge them.
  - If not → add previous interval to result.
- Overlap condition:
  currentStart <= previousEnd

---------------------------------------

Approach:
1. Create a new array of size n + 1.
2. Insert newInterval at correct sorted position.
3. Traverse the new array.
4. Merge overlapping intervals.
5. Convert result list to 2D array.
6. Return final merged intervals.

---------------------------------------

Algorithm:
1. Let n = intervals.length.
2. Create new array arr of size n+1.
3. Insert newInterval in sorted position.
4. Initialize:
   start = arr[0][0]
   end   = arr[0][1]
5. For each interval from index 1:
   - If start overlaps (s <= end):
       end = max(end, e)
   - Else:
       add (start, end) to result
       update start and end
6. Add last interval.
7. Return result as 2D array.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int[][] arr = new int[n + 1][2];

        int j = 0;
        boolean inserted = false;

        // Insert new interval in sorted position
        for (int i = 0; i < n; i++) {

            if (!inserted && newInterval[0] < intervals[i][0]) {
                arr[j++] = newInterval;
                inserted = true;
            }

            arr[j++] = intervals[i];
        }

        if (!inserted) {
            arr[j] = newInterval;
        }

        // Merge intervals
        List<int[]> result = new ArrayList<>();

        int start = arr[0][0];
        int end   = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            int s = arr[i][0];
            int e = arr[i][1];

            if (s <= end) {
                end = Math.max(end, e);
            } 
            else {
                result.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}

/*
---------------------------------------

Example 1:

Input:
intervals = [[1,3],[6,9]]
newInterval = [2,5]

Output:
[[1,5],[6,9]]

---------------------------------------

Example 2:

Input:
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]

Output:
[[1,2],[3,10],[12,16]]

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)

---------------------------------------

Explanation :
"I first insert the new interval
in the correct sorted position.
Then I apply the merge intervals logic.
If intervals overlap,
I merge them by updating the end.
Otherwise, I add the previous interval
to the result list."

---------------------------------------
*/
