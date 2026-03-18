/*
Problem: 704. Binary Search
Link: https://leetcode.com/problems/binary-search/

-----------------------------------------------------

Problem Statement

Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.

If target exists, return its index.
Otherwise, return -1.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search

Why:
Array is sorted → we can eliminate half of the search space
in every step, making it efficient.

-----------------------------------------------------

Key Idea

1. Find mid element.
2. Compare with target.
3. Move left or right accordingly.

-----------------------------------------------------

Algorithm / Process

1. Initialize start = 0, end = n-1
2. While start <= end:
      mid = (start + end) / 2
3. If nums[mid] == target → return mid
4. If nums[mid] > target → search left
5. Else → search right
6. If not found → return -1

-----------------------------------------------------

Code
*/

class Solution {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2; // avoid overflow

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
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
nums = [-1,0,3,5,9,12]
target = 9

Output:
4

-----------------------------------------------------

Explanation :

Since the array is sorted, we apply binary search.
Compare middle element with target and eliminate half
of the search space in each step.
*/
