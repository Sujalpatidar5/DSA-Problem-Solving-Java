/*
LeetCode 724 - Find Pivot Index

Problem Statement:
Given an integer array nums,
return the pivot index of this array.

Pivot index is the index where:
Sum of elements on the left == Sum of elements on the right.

If no such index exists, return -1.

---------------------------------------

Pattern Used:
Prefix Sum

Why this pattern?
- We need sum of left side and right side at every index.
- Instead of recalculating repeatedly,
  we use total sum and running prefix sum.

---------------------------------------

Key Observation:

Let:
totalSum = sum of all elements
leftSum = sum of elements before index i

Then:
rightSum = totalSum - leftSum - nums[i]

If:
leftSum == rightSum

Then:
i is pivot index

---------------------------------------

Approach:

1. Compute total sum of array.
2. Initialize leftSum = 0.
3. Traverse array:
   - rightSum = totalSum - leftSum - nums[i]
   - If leftSum == rightSum -> return i
   - Update leftSum += nums[i]
4. If no pivot found  return -1

---------------------------------------

Algorithm:

1. totalSum = sum of nums
2. leftSum = 0
3. For each index i:
     if leftSum == totalSum - leftSum - nums[i]
         return i
     leftSum += nums[i]
4. Return -1

---------------------------------------

Code:
*/

class Solution {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Step 1: Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Traverse array
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [1,7,3,6,5,6]

At index 3:
Left sum = 1 + 7 + 3 = 11
Right sum = 5 + 6 = 11

Output:
3

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Interview Explanation (Simple):

"I first calculate total sum.
Then while traversing, I maintain left sum.
At each index, I compute right sum using:
totalSum - leftSum - current element.
If both sides are equal, that index is pivot."

---------------------------------------
*/
