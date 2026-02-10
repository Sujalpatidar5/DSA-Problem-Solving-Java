/*
LeetCode 977 - Squares of a Sorted Array

Pattern Used:
Two Pointers

Problem Statement:
Given an integer array `nums` sorted in non-decreasing order,
return an array of the squares of each number also sorted
in non-decreasing order.

Approach:
- Squaring negative numbers can make them larger than positive numbers.
- The largest square will always come from either:
  - the leftmost element (most negative), or
  - the rightmost element (most positive).
- Use two pointers:
  - `left` at start
  - `right` at end
- Fill the result array from the end (`idx = n-1`) to the beginning.

Algorithm:
1. Initialize:
   - left = 0
   - right = n - 1
   - idx = n - 1
2. While left <= right:
   a. Compute square of nums[left] and nums[right]
   b. Place the larger square at ans[idx]
   c. Move the corresponding pointer
   d. Decrement idx
3. Return the result array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Why Two Pointers?
Because the input array is already sorted, and the largest square
will always come from one of the ends.
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];

            if (rightVal > leftVal) {
                ans[idx] = rightVal;
                right--;
            } else {
                ans[idx] = leftVal;
                left++;
            }
            idx--;
        }
        return ans;
    }
}
