/*
Problem: Check if Array is Sorted (GFG)

-----------------------------------------------------

Problem Statement

Given an array arr[], check whether the array is sorted
in non-decreasing order or not.

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion

Why:
- Compare current element with next
- Reduce problem size step by step

-----------------------------------------------------

Key Idea

- Compare arr[i] with arr[i+1]
- If arr[i] > arr[i+1] → not sorted
- Otherwise → check remaining array

-----------------------------------------------------

Algorithm / Process

1. Start from index 0
2. If reached last element → return true
3. If arr[i] > arr[i+1] → return false
4. Else:
      check(i+1)

-----------------------------------------------------

Code
*/

class Solution {

    public boolean isSorted(int[] arr) {
        return check(arr, 0);
    }

    private boolean check(int[] arr, int i) {

        // base case
        if (i == arr.length - 1) return true;

        // not sorted
        if (arr[i] > arr[i + 1]) return false;

        // recursive call
        return check(arr, i + 1);
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
arr = [1,2,3,4]

Output:
true

-----------------------------------------------------

Short Interview Explanation

Compare adjacent elements recursively.
If any pair is unsorted → return false.
*/
