/*
LeetCode 53 - Maximum Subarray

Problem Statement:
Given an integer array `nums`,
find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

---------------------------------------

Pattern Used:
Kadane’s Algorithm

Why this pattern?
- The problem asks for **maximum subarray sum**
- Subarray must be **contiguous**
- Brute force would be O(n²)
- Kadane solves it optimally in O(n)

---------------------------------------

Key Observation:
At each index, we have two choices:
1) Start a new subarray from current element
2) Extend the previous subarray

We choose the option which gives the maximum sum.

---------------------------------------

Approach:
1. Initialize:
   - currSum = nums[0]
   - maxSum  = nums[0]
2. Traverse array from index 1
3. At each index:
   - currSum = max(nums[i], currSum + nums[i])
   - maxSum  = max(maxSum, currSum)
4. Return maxSum

---------------------------------------

Algorithm:
1. Set currSum and maxSum to first element
2. Loop from second element:
   - Decide whether to start fresh or continue
3. Keep updating the global maximum
4. Return final maxSum

---------------------------------------

Code:
*/

class Solution {

    public int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Step-wise:
Maximum subarray = [4, -1, 2, 1]
Sum = 6

Output:
6

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :
"I used Kadane’s Algorithm.
At each index, I decide whether to start a new subarray
or extend the previous one.
I keep track of the maximum sum seen so far
and return it at the end."

---------------------------------------
*/
