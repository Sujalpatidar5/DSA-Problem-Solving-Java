/*
Problem: Triplets with Smaller Sum (GFG)

-----------------------------------------------------

Problem Statement

Given an array arr[] of distinct integers and a value sum,
find the number of triplets (i, j, k) such that:

arr[i] + arr[j] + arr[k] < sum

-----------------------------------------------------

Pattern Used & Why

Pattern: Two Pointers (after sorting)

Why:
If arr[i] + arr[left] + arr[right] < sum,
then all elements between left and right will also work.

-----------------------------------------------------

Key Idea

Agar current sum < target hai,
toh ek hi baar me multiple triplets mil jaate hain.

-> count += (right - left)

-----------------------------------------------------

Algorithm / Process

1. Sort the array
2. Initialize count = 0
3. Fix i from 0 to n-2
4. Set left = i+1, right = n-1
5. While left < right:
      sum = arr[i] + arr[left] + arr[right]

      If sum < target:
          count += (right - left)
          left++
      Else:
          right--

6. Return count

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    long countTriplets(long[] arr, int n, int sum) {

        Arrays.sort(arr);
        long count = 0;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum < sum) {
                    count += (right - left); // multiple triplets
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n^2)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
arr = [-2, 0, 1, 3], sum = 2

Output:
2

Explanation:
Valid triplets:
(-2, 0, 1)
(-2, 0, 3)

-----------------------------------------------------

Explanation :

Sort array.
Fix one element.
Use two pointers.
If sum < target → all elements between left & right valid.
So count += (right - left).
*/
