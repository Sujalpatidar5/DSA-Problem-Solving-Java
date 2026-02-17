/*
LeetCode 904 - Fruit Into Baskets

Problem Statement:
You are given an integer array fruits.
Each element represents a type of fruit.

You have two baskets.
Each basket can hold only one type of fruit.

You must collect fruits from a contiguous subarray.
Return the maximum number of fruits you can collect.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size - Maximum Type)

---------------------------------------

Important Note:

This problem is EXACTLY SAME as:

"Longest Subarray with At Most 2 Distinct Elements"
(Just for clearance)
---------------------------------------

Why this pattern?

- We are dealing with subarray (continuous).
- Window size is not fixed.
- We can have at most 2 distinct elements.
- We want maximum length.

So this is classic Variable Size Sliding Window.

---------------------------------------

Key Observation:

- Expand window using right pointer.
- Maintain frequency of fruit types using HashMap.
- If distinct fruits exceed 2 → shrink window.
- Update answer at every valid window.

---------------------------------------

Approach:

1. Use two pointers:
   left  -> start of window
   right -> end of window

2. Use HashMap to maintain frequency of fruit types.

3. Expand window by moving right.

4. If freq.size() > 2:
      shrink window from left
      until only 2 distinct fruits remain.

5. Update maximum length.

---------------------------------------

Algorithm:

1. Initialize:
      left = 0
      ans = 0
      freq map

2. For right = 0 to n-1:
      Add fruits[right] to map

      while freq.size() > 2:
            Decrease frequency of fruits[left]
            Remove if frequency becomes 0
            left++

      Update ans = max(ans, right - left + 1)

3. Return ans

---------------------------------------

Code:
*/

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int left = 0, ans = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {

            int currFruit = fruits[right];
            freq.put(currFruit, freq.getOrDefault(currFruit, 0) + 1);

            // Shrink window if more than 2 types
            while (freq.size() > 2) {

                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1);

                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }

                left++;
            }

            // Update answer
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
fruits = [1,2,1]

Output:
3

Explanation:
We can collect all fruits because there are only 2 types.

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)  // because at most 2 keys in map

---------------------------------------

Explanation :

"I used Variable Size Sliding Window.
This problem is same as finding the longest subarray
with at most 2 distinct elements.
I maintained a HashMap to track fruit frequencies.
If distinct fruits exceeded 2, I shrank the window.
This gives O(n) time complexity."

---------------------------------------
*/
