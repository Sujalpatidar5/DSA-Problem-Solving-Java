/*
Problem: 162. Find Peak Element
Link: https://leetcode.com/problems/find-peak-element/

-----------------------------------------------------

Problem Statement

A peak element is an element that is strictly greater
than its neighbors.

Given an integer array nums, find a peak element,
and return its index.

You may assume nums[-1] = nums[n] = -∞.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Slope Based)

Why:
We use the slope (increasing/decreasing) to decide
the direction of search.

-----------------------------------------------------

Key Idea

Compare nums[mid] with nums[mid+1]:

- If nums[mid] > nums[mid+1]
  → possible peak → move left

- Else
  → peak on right side

-----------------------------------------------------

Algorithm / Process

1. Initialize left = 0, right = n-1
2. While left <= right:
      mid = (left + right) / 2
3. If mid is last OR nums[mid] > nums[mid+1]:
      store answer
      move left
4. Else:
      move right
5. Return answer

-----------------------------------------------------

Code
*/

class Solution {

    public int findPeakElement(int[] nums) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            // boundary handle
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
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
nums = [1,2,3,1]

Output:
2

-----------------------------------------------------

Explanation :

Use binary search and compare mid with mid+1.
If decreasing, move left and store answer,
otherwise move right.
*/
