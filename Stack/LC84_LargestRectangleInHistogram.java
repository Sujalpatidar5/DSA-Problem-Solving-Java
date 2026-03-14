/*
Problem: 84. Largest Rectangle in Histogram

-----------------------------------------------------

Problem Statement
Given an array heights representing the heights of bars in a histogram,
where the width of each bar is 1, return the area of the largest rectangle
that can be formed in the histogram.

-----------------------------------------------------

Pattern Used & Why
Pattern: Monotonic Stack

Why:
To determine how far each bar can extend left and right while maintaining
its height as the minimum height of the rectangle.

We find:
1. Previous Smaller Element (left boundary)
2. Next Smaller Element (right boundary)

These boundaries tell us the maximum width for each bar.

-----------------------------------------------------

Key Idea

For every bar heights[i]:

left boundary  = index of previous smaller element
right boundary = index of next smaller element

width = right - left - 1
area  = heights[i] * width

Maximum area among all bars is the answer.

-----------------------------------------------------

Algorithm / Process

1. Create two arrays:
   ps[] → previous smaller index
   ns[] → next smaller index

2. Find Next Smaller Element (Right)
   - Traverse from right to left
   - Maintain a monotonic increasing stack
   - Pop elements ≥ current height

3. Clear the stack.

4. Find Previous Smaller Element (Left)
   - Traverse from left to right
   - Pop elements ≥ current height

5. Calculate area for every bar:
   width = ns[i] - ps[i] - 1
   area = heights[i] * width

6. Track the maximum area.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int ns[] = new int[n];   // next smaller index
        int ps[] = new int[n];   // previous smaller index

        Stack<Integer> s = new Stack<>();

        // Next Smaller Element (Right)
        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ns[i] = n;
            } else {
                ns[i] = s.peek();
            }

            s.push(i);
        }

        // clear stack instead of new stack
        s.clear();

        // Previous Smaller Element (Left)
        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ps[i] = -1;
            } else {
                ps[i] = s.peek();
            }

            s.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = ns[i] - ps[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

Each element is pushed and popped from the stack at most once.

-----------------------------------------------------

Space Complexity
O(n)

For stack + boundary arrays.

-----------------------------------------------------

Example

Input:
heights = [2,1,5,6,2,3]

Output:
10

Explanation:
The largest rectangle is formed using bars 5 and 6.

width = 2
height = 5
area = 5 × 2 = 10

-----------------------------------------------------

Explanation :

For every bar we find how far it can expand left and right until a
smaller bar appears. Using a monotonic stack we efficiently find the
previous and next smaller elements in O(n). The width of the rectangle
for each bar is determined by these boundaries, and the maximum area
is returned.
*/
