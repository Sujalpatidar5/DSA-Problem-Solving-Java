/*
5.
Problem: 852. Peak Index in a Mountain Array
Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

-----------------------------------------------------

Problem Statement

An array arr is a mountain array if:

- arr.length >= 3
- There exists some i such that:
      arr[0] < arr[1] < ... < arr[i]
      arr[i] > arr[i+1] > ... > arr[n-1]

Return the index of the peak element.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Peak Finding)

Why:
The array first increases then decreases.
We can decide direction using mid and mid+1.

-----------------------------------------------------

Key Idea

Compare:
arr[mid] with arr[mid + 1]

1. If arr[mid] < arr[mid+1]
   → We are in increasing part
   → Peak is on RIGHT

2. Else
   → We are in decreasing part OR at peak
   → Store mid and move LEFT

-----------------------------------------------------

Algorithm / Process

1. Initialize left = 0, right = n-1
2. While left <= right:
      mid = (left + right) / 2
3. If arr[mid] < arr[mid+1]:
      move right → left = mid + 1
4. Else:
      store mid as answer
      move left → right = mid - 1
5. Return answer

-----------------------------------------------------

Code
*/

class Solution {

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // increasing → peak on right
                left = mid + 1;
            } else {
                // decreasing → possible peak
                ans = mid;
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
arr = [0,2,5,3,1]

Output:
2

Explanation:
Peak element = 5 at index 2

-----------------------------------------------------

Explanation :

Compare mid with mid+1.
If increasing → go right,
if decreasing → go left and store answer.
This finds peak in O(log n).
*/
