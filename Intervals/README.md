# Interval Pattern (Merge Intervals Type)

---------------------------------------

# Definition:

An interval is a pair of values:
[start, end]

It represents a range between two points.

Example:
[1,3], [2,6], [8,10]

---------------------------------------

## Common Keywords (Very Important)

If question contains words like:

- Overlap
- Conflict
- Merge
- Free time
- Meeting rooms
- Simultaneous usage
- CPU load
- Room booking
- Time ranges
- Schedule

-> Then think of INTERVAL pattern.

---------------------------------------

## Core Idea of Interval Problems

1. Sort intervals by start time.
2. Traverse intervals one by one.
3. Compare current interval with previous one.
4. If overlapping → merge.
5. If not overlapping → add separately.

---------------------------------------

# Time Complexity:

O(n log n)  → because of sorting
O(n)        → traversal

---------------------------------------

# Explanation :

"I sorted the intervals by start time.
Then I traversed and merged overlapping ones.
If no overlap, I added it separately."

---------------------------------------
