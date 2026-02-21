/*
LeetCode 2574 - Left and Right Sum Differences

Problem Statement:
Given a 0-indexed integer array nums,
find a 0-indexed integer array answer where:

answer[i] =
|sum of elements to the left of index i
 - sum of elements to the right of index i|

---------------------------------------

Pattern Used:
Prefix Sum (Total Sum + Running Left Sum)

Why this pattern?
- We need left sum and right sum at every index.
- Instead of computing again and again (O(n²)),
  we compute total sum once.
- Then use running left sum to get right sum efficiently.

---------------------------------------

Key Observation:

Right Sum at index i =
totalSum - leftSum - nums[i]

Because:
totalSum =
left part + current element + right part

So,
right part = totalSum - leftSum - current element

---------------------------------------

Approach:

1. Compute total sum of array.
2. Initialize leftSum = 0.
3. Traverse array:
   - rightSum = totalSum - leftSum - nums[i]
   - answer[i] = |rightSum - leftSum|
   - Update leftSum += nums[i]
4. Return answer array.

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)  (for answer array)

---------------------------------------
*/

class Solution {

    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int ans[] = new int[n];

        int totalSum = 0;

        // Step 1: Calculate total sum
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0, rightSum = 0;

        // Step 2: Calculate answer
        for (int i = 0; i < n; i++) {

            rightSum = totalSum - leftSum - nums[i];

            ans[i] = Math.abs(rightSum - leftSum);

            leftSum += nums[i];
        }

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [10, 4, 8, 3]

Total Sum = 25

Index 0:
left = 0
right = 25 - 0 - 10 = 15
ans[0] = |15 - 0| = 15

Index 1:
left = 10
right = 25 - 10 - 4 = 11
ans[1] = |11 - 10| = 1

Output:
[15, 1, 11, 22]

---------------------------------------

Explanation :

"I first computed total sum.
Then while traversing,
I maintained a running left sum.
Right sum was calculated using:
totalSum - leftSum - current element.
This avoids recomputing sums
and gives O(n) solution."

---------------------------------------
*/
