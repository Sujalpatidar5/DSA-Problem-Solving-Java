/*
LeetCode 918 - Maximum Sum Circular Subarray

Problem Statement:
Given a circular integer array nums of length n,
return the maximum possible sum of a non-empty subarray of nums.

A circular array means:
The element after nums[n-1] is nums[0].

---------------------------------------

Pattern Used:
Kadane’s Algorithm (Extended for Circular Array)

Why this pattern?

This problem has two possible cases:

1) Normal maximum subarray (non-circular)
   - Solve using classic Kadane’s Algorithm

2) Circular maximum subarray
   - Means we take elements from end + beginning
   - Equivalent to:
       totalSum - minimumSubarraySum

So we calculate:
- Maximum subarray sum
- Minimum subarray sum
- Total sum

Then answer =
max(maxSubarraySum, totalSum - minSubarraySum)

---------------------------------------

Key Observation:

Circular maximum subarray means:
We exclude the worst (minimum) subarray
and take the rest of the array.

So:
CircularMax = totalSum - minSubarraySum

Final Answer:
If all elements are negative:
    return maxSubarraySum

Else:
    return max(maxSubarraySum, totalSum - minSubarraySum)

---------------------------------------

Approach:

1. Use Kadane’s Algorithm to find:
   - Maximum subarray sum

2. Use Reverse Kadane to find:
   - Minimum subarray sum

3. Compute total sum of array

4. If maxSum < 0:
      return maxSum

   Else:
      return max(maxSum, totalSum - minSum)

---------------------------------------

Algorithm:

1. Initialize:
   maxEnding = nums[0]
   minEnding = nums[0]
   maxSum = nums[0]
   minSum = nums[0]
   totalSum = nums[0]

2. Traverse from index 1:
   - Update totalSum
   - Update maxEnding
   - Update maxSum
   - Update minEnding
   - Update minSum

3. If maxSum < 0:
      return maxSum

4. Else:
      return max(maxSum, totalSum - minSum)

---------------------------------------

Code:
*/

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            totalSum += nums[i];

            // Normal Kadane
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            // Reverse Kadane
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }

        // If all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Return max of normal and circular case
        return Math.max(maxSum, totalSum - minSum);
    }
}

/*
---------------------------------------

Example:

Input:
nums = [5, -3, 5]

Normal Maximum Subarray sum:
5 + (-3) + 5 = 7

Minimum Subarray sum:
[-3]

Total Sum:
5 + (-3) + 5 = 7

Circular Maximum:
7 - (-3) = 10

Output:
10

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

 Explanation :

"I solved it using Kadane’s algorithm.
First, I found the normal maximum subarray sum.
Then I found the minimum subarray sum.
For circular cases, the maximum sum equals
total sum minus minimum subarray sum.
Finally, I returned the maximum of both cases,
handling the edge case where all elements are negative."

---------------------------------------
*/
