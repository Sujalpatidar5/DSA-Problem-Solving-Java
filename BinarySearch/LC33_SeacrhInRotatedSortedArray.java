/*
7.
Problem: 33. Search in Rotated Sorted Array
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

-----------------------------------------------------

Problem Statement

There is an integer array nums sorted in ascending order,
but rotated at some pivot.

Given nums and target, return its index if found,
otherwise return -1.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Rotated Array)

Why:
Even after rotation, one half of the array is always sorted.
We use this property to decide search direction.

-----------------------------------------------------

Key Idea

At every step:

1. One half is always sorted:
   - Left sorted OR Right sorted

2. Check where target lies:
   - If inside sorted half → go there
   - Else → go to other half

-----------------------------------------------------

Algorithm / Process

1. Initialize left = 0, right = n-1
2. While left <= right:
      mid = (left + right) / 2
3. If nums[mid] == target → return mid

4. If LEFT part sorted:
      nums[left] <= nums[mid]
      → check if target in this range
         yes → go left
         no  → go right

5. Else RIGHT part sorted:
      → check if target in this range
         yes → go right
         no  → go left

6. If not found → return -1

-----------------------------------------------------

Code
*/

class Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // found
            if (nums[mid] == target) {
                return mid;
            }

            // LEFT part sorted
            if (nums[left] <= nums[mid]) {

                // target in left range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } 
            // RIGHT part sorted
            else {

                // target in right range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(log n)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
nums = [4,5,6,7,0,1,2]
target = 0

Output:
4

-----------------------------------------------------

Explanation :

At every step, one half is sorted.
Check if target lies in that half.
If yes → go there, else → search the other half.
*/
