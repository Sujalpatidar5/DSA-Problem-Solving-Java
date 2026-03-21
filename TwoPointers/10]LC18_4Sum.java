/*
Problem: 18. 4Sum (LeetCode)

-----------------------------------------------------

Problem Statement

Given an array nums of n integers and an integer target,
return all unique quadruplets [a, b, c, d] such that:

a + b + c + d = target

-----------------------------------------------------

Pattern Used & Why

Pattern: Sorting + Two Pointers

Why:
Fix first 2 elements → reduce problem to 2Sum using two pointers

-----------------------------------------------------

Key Idea

- Sort array
- Fix i and j
- Use left & right pointers
- Handle duplicates carefully
- Use long to avoid overflow

-----------------------------------------------------

Algorithm / Process

1. Sort array
2. Fix i from 0 → n-4
3. Fix j from i+1 → n-3
4. Use two pointers:
      left = j+1, right = n-1
5. If sum == target → store answer
6. Skip duplicates
7. Move both pointers

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        if (n < 4) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    // cast to long BEFORE addition → avoid overflow

                    if (sum == target) {

                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // skip duplicates for right
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;

                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n^3)

-----------------------------------------------------

Space Complexity
O(1) (excluding result)

-----------------------------------------------------

Example

Input:
nums = [1,0,-1,0,-2,2], target = 0

Output:
[
 [-2,-1,1,2],
 [-2,0,0,2],
 [-1,0,0,1]
]

-----------------------------------------------------

Explanation :

Sort array.
Fix 2 elements.
Baaki 2 ke liye two pointers use karo.
Duplicate avoid karo.
Overflow avoid karne ke liye long use karo.

*/
