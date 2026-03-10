/*
LeetCode 739 - Daily Temperatures

---------------------------------------

Problem Statement:

Given an array of integers temperatures representing
the daily temperatures, return an array answer such that
answer[i] is the number of days you have to wait after
the ith day to get a warmer temperature.

If there is no future day for which this is possible,
keep answer[i] = 0.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Monotonic Stack (Next Greater Element - Index Based)

Why?

We need to find the next greater temperature on the right side.
Using brute force would require checking all future days,
which takes O(n²).

Using a monotonic stack helps efficiently remove smaller
temperatures and find the next greater temperature in O(n).

---------------------------------------

Key Idea:

1. Traverse the array from right to left.
2. Maintain a stack storing indices of temperatures.
3. Remove elements from the stack whose temperature
   is smaller than or equal to the current temperature.
4. The top of the stack gives the next warmer day.
5. Calculate the number of days using:
   nextIndex - currentIndex.

---------------------------------------

Algorithm / Process:

1. Let n = temperatures.length.
2. Create answer array ans of size n.
3. Create a stack to store indices.
4. Traverse from index n-1 to 0.
5. For each index i:
   - Remove stack elements while
     temperatures[stack.peek()] <= temperatures[i].
6. If stack becomes empty → ans[i] = 0.
7. Otherwise → ans[i] = stack.peek() - i.
8. Push current index into stack.
9. Return ans array.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n-1; i >= 0; i--) {

            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek() - i;
            }

            s.push(i);
        }

        return ans;
    }
}

/*
---------------------------------------

Time Complexity:

O(n)

Explanation:
Each index is pushed and popped from the stack
at most once.

---------------------------------------

Space Complexity:

O(n)

Explanation:
Stack may contain up to n indices in the worst case.

---------------------------------------

Example:

Input:
temperatures = [73,74,75,71,69,72,76,73]

Output:
[1,1,4,2,1,1,0,0]

Explanation:

73 → next warmer = 74 → 1 day
74 → next warmer = 75 → 1 day
75 → next warmer = 76 → 4 days
71 → next warmer = 72 → 2 days
69 → next warmer = 72 → 1 day
72 → next warmer = 76 → 1 day
76 → no warmer day → 0
73 → no warmer day → 0

---------------------------------------

Explanation:

"I used a monotonic decreasing stack storing indices.
While traversing from right to left, I removed
temperatures smaller or equal to the current one.
The remaining top index gives the next warmer day.
The difference of indices gives the number of days."

---------------------------------------
*/
