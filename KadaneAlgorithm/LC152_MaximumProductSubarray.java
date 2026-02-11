/*
LeetCode 152 - Maximum Product Subarray

Problem Statement:
Given an integer array `nums`,
find the contiguous subarray within the array
which has the largest product and return the product.

---------------------------------------

Pattern Used:
Kadane’s Algorithm (Modified for Product)

Why this pattern?
- This is a contiguous subarray problem.
- We need an O(n) optimal solution.
- Normal Kadane works for sum.
- For product, negative numbers can flip sign.
- A negative × negative can become maximum.

So we track:
1) Maximum product ending at current index
2) Minimum product ending at current index

---------------------------------------

Key Observation:
At each index, three possibilities exist:

v1 = current element itself  
v2 = current element × previous maxEnding  
v3 = current element × previous minEnding  

Why previous minEnding?
Because negative × negative = positive,
which can become new maximum.

So:
maxEnding = max(v1, v2, v3)
minEnding = min(v1, v2, v3)

---------------------------------------

Approach:
1. Initialize:
   - maxEnding = nums[0]
   - minEnding = nums[0]
   - ans = nums[0]
2. Traverse array from index 1
3. For each element:
   - Calculate v1, v2, v3
   - Update maxEnding
   - Update minEnding
   - Update answer
4. Return ans

---------------------------------------

Algorithm:
1. maxEnding = nums[0]
   minEnding = nums[0]
   ans = nums[0]

2. For i from 1 to n-1:
   - v1 = nums[i]
   - v2 = maxEnding * nums[i]
   - v3 = minEnding * nums[i]
   - maxEnding = max(v1, v2, v3)
   - minEnding = min(v1, v2, v3)
   - ans = max(ans, maxEnding)

3. Return ans

---------------------------------------

Code:
*/

class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {

            // store three possibilities
            int v1 = nums[i];
            int v2 = maxEnding * nums[i];
            int v3 = minEnding * nums[i];

            // update max and min
            maxEnding = Math.max(v1, Math.max(v2, v3));
            minEnding = Math.min(v1, Math.min(v2, v3));

            // update global answer
            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [2,3,-2,4]

Step-by-step:
2 → max=2
3 → max=6
-2 → flips sign
4 → final max remains 6

Output:
6

---------------------------------------

Another Example:

Input:
nums = [-2,0,-1]

Output:
0

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :
"I used a modified Kadane’s Algorithm.
Because multiplication with negative numbers
can flip the sign, I tracked both maximum
and minimum product at each index.
Then I updated the global maximum answer."

---------------------------------------
*/
