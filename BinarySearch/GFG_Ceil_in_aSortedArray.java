/*
Problem: Ceil in a Sorted Array (GFG)

-----------------------------------------------------

Problem Statement

Given a sorted array arr[] and a number x,
find the index of the smallest element in the array
which is greater than or equal to x (i.e., ceil of x).

If no such element exists, return -1.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (Lower Bound)

Why:
We need the first element ≥ x.
Binary search helps efficiently find this position in O(log n).

-----------------------------------------------------

Key Idea

Whenever arr[mid] >= x:
→ This can be a possible answer
→ But we try to find a smaller index on the left

So we move left (right = mid - 1)

-----------------------------------------------------

Algorithm / Process

1. Initialize:
      left = 0, right = n - 1
      ans = -1
2. While left <= right:
      mid = left + (right - left) / 2
3. If arr[mid] >= x:
      store mid in ans
      move left → right = mid - 1
4. Else:
      move right → left = mid + 1
5. Return ans

-----------------------------------------------------

Code
*/

class Solution {

    public int ceil(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = mid;        // possible answer
                right = mid - 1;  // search on left side
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
arr = [1, 2, 4, 6, 8]
x = 5

Output:
3

Explanation:
Ceil of 5 is 6 → index = 3

-----------------------------------------------------

Explanation :

Use binary search to find the first element ≥ x.
Whenever condition satisfies, store index and move left
to get the smallest valid index.
*/
