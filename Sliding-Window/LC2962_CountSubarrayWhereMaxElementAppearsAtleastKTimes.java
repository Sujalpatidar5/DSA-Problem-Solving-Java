/*
LeetCode 2962 - Count Subarrays Where Max Element Appears at Least K Times

Problem Statement:
You are given an integer array nums and an integer k.

Return the number of subarrays where the maximum element of the array
appears at least k times in that subarray.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size)

Why this pattern?

- We need to count subarrays.
- Condition depends on frequency of the maximum element.
- Window size is not fixed.
- We expand the window using right pointer.
- When condition is satisfied (max element appears ≥ k times),
  we shrink from left and count valid subarrays.

---------------------------------------

Key Idea:

1. First find the maximum element of the array.
2. Use sliding window to maintain a window where
   the max element appears at least k times.
3. When the window satisfies the condition:
   every extension of this window to the right
   will also be valid.

So we add:

(n - right)

to the answer.

---------------------------------------

Approach:

1. Find the maximum element in nums.
2. Use two pointers:
   left and right.
3. Track countMax = number of times max appears in window.
4. Expand window using right pointer.
5. When countMax ≥ k:
   - add (n - right) to answer
   - shrink window from left.
6. Continue until right reaches end.

---------------------------------------

Algorithm:

1. Find max element of array.
2. Initialize:
   left = 0
   countMax = 0
   ans = 0
3. Traverse array using right pointer.
4. If nums[right] == max → increment countMax.
5. While countMax ≥ k:
   - ans += (n - right)
   - if nums[left] == max → decrement countMax
   - left++
6. Return ans.

---------------------------------------

Code:
*/

class Solution {

    public long countSubarrays(int[] nums, int k) {

        int n = nums.length;

        // Step 1: find max element
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int countMax = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {

            if (nums[right] == max)
                countMax++;

            while (countMax >= k) {

                ans += (n - right);

                if (nums[left] == max)
                    countMax--;

                left++;
            }
        }

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [1,3,2,3,3]
k = 2

Output:
6

Explanation:

Maximum element = 3

Valid subarrays where 3 appears at least twice:

[3,2,3]
[3,2,3,3]
[2,3,3]
[3,3]
[3,2,3]
[3,3]

Total = 6

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :

"I first find the maximum element in the array.
Then I use a sliding window to track how many times
the maximum element appears in the current window.
Whenever it appears at least k times,
all extensions of that window to the right are valid,
so I add (n - right) to the answer and shrink the window."

---------------------------------------
*/
