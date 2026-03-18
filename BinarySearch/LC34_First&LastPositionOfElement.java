/*
Problem: 34. Find First and Last Position of Element in Sorted Array
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

-----------------------------------------------------

Problem Statement

Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.

If target is not found, return [-1, -1].

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Modified)

Why:
We need both first and last occurrence.
Binary search helps us find them efficiently in O(log n).

-----------------------------------------------------

Key Idea

1. Use Binary Search twice:
   - First occurrence → go LEFT after finding target
   - Last occurrence → go RIGHT after finding target

-----------------------------------------------------

Algorithm / Process

1. Call findFirst():
      → find first index of target
2. Call findLast():
      → find last index of target
3. Return both in array

-----------------------------------------------------

Code
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    // FIRST occurrence
    public int findFirst(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;          // store answer
                right = mid - 1;    // go LEFT
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // LAST occurrence
    public int findLast(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;          // store answer
                left = mid + 1;     // go RIGHT
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
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
nums = [5,7,7,8,8,10]
target = 8

Output:
[3,4]

-----------------------------------------------------

Explanation :

Use binary search twice:
First to find leftmost occurrence (move left after match),
second to find rightmost occurrence (move right after match).
*/
