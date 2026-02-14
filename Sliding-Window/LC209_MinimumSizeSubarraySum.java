/*
LeetCode 209 - Minimum Size Subarray Sum

Problem Statement:
Given an array of positive integers nums and an integer target,
return the minimal length of a contiguous subarray 
of which the sum is greater than or equal to target.

If there is no such subarray, return 0.

--------------------------------------------------

Pattern Used:
Sliding Window (Variable Size - Minimum Type)

--------------------------------------------------

Why this pattern?

- We are dealing with a subarray (continuous elements).
- Window size is NOT fixed.
- We need minimum length.
- All elements are positive → window can safely shrink.

This is classic Variable Size Sliding Window (Min Type).

--------------------------------------------------

Key Observation:

Since all numbers are positive:

- Expanding window → sum increases
- Shrinking window → sum decreases

So:
1) Expand until sum >= target
2) Then shrink to minimize window size
3) Keep updating minimum length

--------------------------------------------------

Approach:

1. Initialize:
   - left = 0
   - sum = 0
   - ans = infinity
2. Expand window using right pointer.
3. Add nums[right] to sum.
4. While sum >= target:
     - Update minimum length
     - Shrink window from left
5. If ans is never updated → return 0
6. Otherwise return ans

--------------------------------------------------

Algorithm:

1. left = 0
2. sum = 0
3. ans = Integer.MAX_VALUE

4. For right = 0 to n-1:
       sum += nums[right]

       while (sum >= target):
            ans = min(ans, right - left + 1)
            sum -= nums[left]
            left++

5. If ans == Integer.MAX_VALUE:
       return 0
   else
       return ans

--------------------------------------------------

Code:
*/

class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                ans = Math.min(ans, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

/*
--------------------------------------------------

Example:

Input:
target = 7
nums = [2,3,1,2,4,3]

Process:
[2,3,1,2] → sum = 8 → length = 4
Shrink → [3,1,2] → 6 (stop)
Expand → [3,1,2,4] → 10
Shrink → [1,2,4] → 7 → length = 3
Shrink → [2,4] → 6 (stop)
Expand → [2,4,3] → 9
Shrink → [4,3] → 7 → length = 2 (minimum)

Output:
2

--------------------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

--------------------------------------------------

Explanation :

"I used Variable Size Sliding Window.
Since all numbers are positive, I expanded the window
until sum became >= target.
Then I shrank the window to minimize its length.
I kept updating the minimum size.
This gives O(n) time complexity."

--------------------------------------------------
*/
