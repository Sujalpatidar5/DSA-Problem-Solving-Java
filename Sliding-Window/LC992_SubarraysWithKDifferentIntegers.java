/*
LeetCode 992 - Subarrays with K Different Integers

Problem Statement:
Given an integer array nums and an integer k,
return the number of good subarrays of nums.

A good subarray is a contiguous subarray that
contains exactly k distinct integers.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size) + HashMap

Why this pattern?

- We need to count subarrays.
- Condition depends on number of distinct elements.
- Window size is not fixed.
- HashMap is used to maintain frequency of elements
  inside the current window.

Important trick:
Subarrays with EXACTLY K distinct =
Subarrays with AT MOST K distinct
− Subarrays with AT MOST (K-1) distinct

---------------------------------------

Key Idea:

Instead of directly finding subarrays with
exactly k distinct elements, we calculate:

atMost(k) → number of subarrays with ≤ k distinct  
atMost(k-1) → number of subarrays with ≤ k-1 distinct

Then subtract:

exactlyK = atMost(k) − atMost(k-1)

---------------------------------------

Approach:

1. Create helper function atMost(k).
2. Use sliding window with HashMap to store
   frequency of elements.
3. Expand window using right pointer.
4. If number of distinct elements exceeds k,
   shrink window from left.
5. For every right pointer position,
   count valid subarrays:

   ans += (right - left + 1)

6. Final answer:

   atMost(k) − atMost(k-1)

---------------------------------------

Algorithm:

1. Define function subarraysWithKDistinct(nums, k)
2. Return:
      atMost(nums, k) - atMost(nums, k-1)

3. Helper function atMost(arr, k):
      - Use HashMap for frequency
      - Maintain sliding window
      - If distinct elements > k → shrink window
      - Add valid window size to answer

---------------------------------------

Code:
*/

import java.util.HashMap;

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int arr[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, ans = 0;

        for (int right = 0; right < arr.length; right++) {

            int curr = arr[right];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // shrink window if distinct elements exceed k
            while (map.size() > k) {

                int leftNum = arr[left];
                map.put(leftNum, map.get(leftNum) - 1);

                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }

                left++;
            }

            // count valid subarrays
            ans += (right - left + 1);
        }

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [1,2,1,2,3]
k = 2

Output:
7

Explanation:

Subarrays with exactly 2 distinct elements:

[1,2]
[2,1]
[1,2]
[2,3]
[1,2,1]
[2,1,2]
[1,2,1,2]

Total = 7

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(k)

---------------------------------------

 Explanation :

"I use sliding window with HashMap to count
subarrays with at most k distinct elements.
Then I subtract subarrays with at most (k-1)
distinct elements to get exactly k distinct
subarrays."

---------------------------------------
*/
