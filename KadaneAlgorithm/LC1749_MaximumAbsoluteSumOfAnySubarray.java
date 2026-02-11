/*
LeetCode 1749 - Maximum Absolute Sum of Any Subarray

Problem Statement:
Given an integer array `nums`,
return the maximum absolute sum of any subarray.

---------------------------------------

Pattern Used:
Kadane’s Algorithm (Extended)

Why this pattern?
- We need the maximum subarray sum → classic Kadane
- We also need the minimum subarray sum (most negative)
- Absolute value can be maximum from:
  - largest positive sum
  - OR largest negative sum (by absolute)

So we apply Kadane twice:
1) For maximum subarray sum
2) For minimum subarray sum

---------------------------------------

Key Observation:
- Absolute sum means:
    |subarray sum|
- Maximum absolute value can come from:
    1) Maximum positive subarray sum
    2) Minimum (most negative) subarray sum

Final Answer:
max(
    maxSubarraySum,
    abs(minSubarraySum)
)

---------------------------------------

Approach:
1. Use Kadane’s Algorithm to find:
   - Maximum subarray sum
2. Modify Kadane’s Algorithm to find:
   - Minimum subarray sum
3. Return the maximum of:
   - maxSum
   - absolute(minSum)

---------------------------------------

Algorithm:
1. Initialize:
   - maxEnding, minEnding = nums[0]
   - maxAns, minAns = nums[0]
2. Traverse array from index 1:
   - Update maxEnding using Kadane logic
   - Update minEnding using reverse Kadane logic
3. Final result:
   max(maxAns, abs(minAns))

---------------------------------------

Code:
*/

class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int maxSum = maxSubarraySum(nums);
        int minSum = minSubarraySum(nums);

        return Math.max(maxSum, Math.abs(minSum));
    }

    // Kadane for maximum subarray sum
    private int maxSubarraySum(int[] nums) {
        int maxEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            ans = Math.max(ans, maxEnding);
        }
        return ans;
    }

    // Kadane for minimum subarray sum
    private int minSubarraySum(int[] nums) {
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            ans = Math.min(ans, minEnding);
        }
        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [1, -3, 2, 3, -4]

Maximum Subarray Sum:
[2, 3] → sum = 5

Minimum Subarray Sum:
[-3] → sum = -3

Maximum Absolute Sum:
max(5, | -3 |) = 5

Output:
5

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :
"I used Kadane’s algorithm twice.
One time to get the maximum subarray sum,
and one time to get the minimum subarray sum.
Because absolute value can be highest for both
positive and negative sums, I returned the maximum
of these two values."

---------------------------------------
*/
