/*
Problem: 16. 3Sum Closest
Link: https://leetcode.com/problems/3sum-closest/

-----------------------------------------------------

Problem Statement

Given an integer array nums and an integer target,
find three integers such that the sum is closest to target.

Return the sum of the three integers.

-----------------------------------------------------

Pattern Used & Why

Pattern: Two Pointers (after sorting)

Why:
Fix one element, then use two pointers to find closest sum.

-----------------------------------------------------

Key Idea

1. Sort the array
2. Fix one element (i)
3. Use left and right pointers
4. Compare sum with target
5. Update closest sum

-----------------------------------------------------

Algorithm / Process

1. Sort nums
2. Initialize closestSum
3. Loop i from 0 to n-2:
      left = i+1, right = n-1
4. While left < right:
      sum = nums[i] + nums[left] + nums[right]

5. If sum == target → return target

6. Update closestSum if needed

7. If sum < target → left++
   Else → right--

8. Return closestSum

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        // initialize closest sum
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // exact match
                if (sum == target) {
                    return target;
                }

                int diff = Math.abs(target - sum);
                int minDiff = Math.abs(target - closestSum);

                // update closest
                if (diff < minDiff) {
                    closestSum = sum;
                }

                // move pointers
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
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
nums = [-1,2,1,-4], target = 1

Output:
2

-----------------------------------------------------

Explanation :

Sort the array.
Fix one element and use two pointers to find closest sum.
Update answer whenever we get closer to target.
*/
