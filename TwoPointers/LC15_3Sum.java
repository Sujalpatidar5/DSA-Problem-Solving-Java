/*
LeetCode 15 - 3Sum

Pattern Used:
Two Pointers + Sorting

Problem Statement:
Given an integer array nums, return all the unique triplets
[nums[i], nums[j], nums[k]] such that:
- i != j, i != k, and j != k
- nums[i] + nums[j] + nums[k] == 0

The solution set must not contain duplicate triplets.

Approach:
1. Sort the array.
2. Fix one element nums[i].
3. Use two pointers:
   - left = i + 1
   - right = n - 1
4. Check the sum of nums[i] + nums[left] + nums[right].
5. Move pointers based on the sum:
   - sum == 0 → store triplet and skip duplicates
   - sum < 0 → move left pointer
   - sum > 0 → move right pointer
6. Skip duplicate values for i, left, and right to avoid duplicate triplets.

Algorithm:
1. Sort the array.
2. Loop i from 0 to n-3:
   a. Skip duplicate nums[i].
   b. Set left = i+1, right = n-1.
   c. While left < right:
      - Calculate sum.
      - If sum == 0:
        * add triplet
        * skip duplicates
        * move both pointers
      - If sum < 0 → left++
      - If sum > 0 → right--
3. Return result list.

Time Complexity:
O(n²)

Space Complexity:
O(1) extra space (excluding output list)

Why Two Pointers?
After sorting, moving left/right pointers efficiently finds
pairs that complete the triplet sum.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate fixed element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
