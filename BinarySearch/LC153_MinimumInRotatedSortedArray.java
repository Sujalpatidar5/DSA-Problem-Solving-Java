/*
6.
Problem: 153. Find Minimum in Rotated Sorted Array
Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

-----------------------------------------------------

Problem Statement

Suppose an array sorted in ascending order is rotated
at some pivot unknown to you beforehand.

Given the rotated sorted array nums,
return the minimum element.

You must write an algorithm that runs in O(log n) time.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Rotated Array)

Why:
Array is partially sorted.
We can decide which half contains the minimum.

-----------------------------------------------------

Key Idea

Compare nums[mid] with nums[n-1]:

1. If nums[mid] > nums[n-1]
   → Minimum is on RIGHT side

2. Else
   → nums[mid] can be answer
   → Minimum is on LEFT side (including mid)

-----------------------------------------------------

Algorithm / Process

1. Initialize left = 0, right = n-1
2. ans = nums[0]
3. While left <= right:
      mid = (left + right) / 2
4. If nums[mid] > nums[n-1]:
      left = mid + 1
5. Else:
      store nums[mid] as answer
      move left → right = mid - 1
6. Return ans

-----------------------------------------------------

Code
*/

class Solution {

    public int findMin(int[] nums) {

        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = nums[0];

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[n - 1]) {
                // minimum on right side
                left = mid + 1;
            } else {
                // possible answer
                ans = nums[mid];
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
nums = [4,5,6,7,0,1,2]

Output:
0

-----------------------------------------------------

Explanation :

Compare mid with last element.
If mid > last → minimum on right.
Else → mid can be answer, move left.
*/
