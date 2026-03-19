/*
Problem: Count Occurrences in Sorted Array (GFG)

-----------------------------------------------------

Problem Statement

Given a sorted array arr[] and a number x,
count the number of occurrences of x in the array.

If x is not present, return 0.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search (First & Last Occurrence)

Why:
Instead of scanning the whole array (O(n)),
we use binary search to find:
- First occurrence
- Last occurrence

Then count = last - first + 1

-----------------------------------------------------

Key Idea

1. Find first occurrence of x.
2. Find last occurrence of x.
3. If not found → return 0
4. Else → return (last - first + 1)

-----------------------------------------------------

Algorithm / Process

1. Call findFirst():
      → gives first index
2. If first == -1 → return 0
3. Call findLast():
      → gives last index
4. Return last - first + 1

-----------------------------------------------------

Code
*/

class Solution {

    int count(int[] arr, int n, int x) {

        int first = findFirst(arr, x);

        if (first == -1)
            return 0;

        int last = findLast(arr, x);

        return last - first + 1;
    }

    // FIRST occurrence
    int findFirst(int[] arr, int x) {

        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                ans = mid;
                right = mid - 1;   // go LEFT
            }
            else if (arr[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // LAST occurrence
    int findLast(int[] arr, int x) {

        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                ans = mid;
                left = mid + 1;    // go RIGHT
            }
            else if (arr[mid] < x) {
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
arr = [1,2,2,2,3,4]
x = 2

Output:
3

Explanation:
First index = 1
Last index = 3
Count = 3

-----------------------------------------------------

Explanation :

Use binary search twice to find first and last occurrence.
Then calculate count using (last - first + 1).
*/
