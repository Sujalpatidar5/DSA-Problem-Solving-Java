/*
LeetCode 1004 - Max Consecutive Ones III

Problem Statement:
Given a binary array nums and an integer k,
return the maximum number of consecutive 1’s
in the array if you can flip at most k 0’s.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size - Maximum Type)

Why this pattern?
- We need longest subarray.
- Condition: at most k zeroes allowed.
- Window expands using right pointer.
- If zeroes exceed k → shrink from left.

---------------------------------------

Key Observation:

In a valid window:
number of zeroes <= k

If zeroes > k:
window becomes invalid
→ shrink from left
→ reduce zero count

---------------------------------------

Approach:

1. Use two pointers:
   - left → start of window
   - right → end of window
2. Count number of zeroes in current window.
3. If zeroes > k:
   shrink window from left.
4. Update maximum length.

---------------------------------------

Algorithm:

1. Initialize:
   left = 0
   maxLen = 0
   zeroes = 0

2. Traverse using right pointer:
   - If nums[right] == 0 → zeroes++
   - While zeroes > k:
        if nums[left] == 0 → zeroes--
        left++
   - Update maxLen

3. Return maxLen

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------
*/

class Solution {

    public int longestOnes(int[] nums, int k) {

        int left = 0, maxLen = 0;
        int zeroes = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroes++;
            }

            // shrink window from left
            while (zeroes > k) {

                int leftNum = nums[left];

                if (leftNum == 0) {
                    zeroes--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

We can flip at most 2 zeroes.

Longest valid window:
[1,1,1,0,0,1,1,1,1]
Length = 6

Output:
6

---------------------------------------

Explanation :

"I used sliding window.
I allowed at most k zeroes in the window.
If zeroes exceeded k,
I shrank the window from the left.
At each step I updated the maximum length."

---------------------------------------
*/
