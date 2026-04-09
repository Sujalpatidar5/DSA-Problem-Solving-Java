/*
Problem: 78. Subsets

-----------------------------------------------------

Problem Statement

Given an integer array nums,
return all possible subsets (the power set).

-----------------------------------------------------

Pattern Used & Why

Pattern: Backtracking (Include / Exclude)

Why:
- At every index → 2 choices:
  1. Include element
  2. Exclude element

-----------------------------------------------------

Key Idea

For each element:
- Take it
- Don’t take it

This forms a decision tree.

-----------------------------------------------------

Algorithm / Process

1. Start from index 0
2. Base case: when index reaches end → add subset
3. Include current element → recurse
4. Undo (backtrack)
5. Exclude current element → recurse

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        subset(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void subset(int[] nums, int i, List<Integer> ans, List<List<Integer>> res) {

        // base case
        if (i == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // include (yes)
        ans.add(nums[i]);
        subset(nums, i + 1, ans, res);

        // undo (backtrack)
        ans.remove(ans.size() - 1);

        // exclude (no)
        subset(nums, i + 1, ans, res);
    }
}

/*
-----------------------------------------------------

Time Complexity
O(2^n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
nums = [1,2]

Output:
[ [1,2], [1], [2], [] ]

-----------------------------------------------------

Explanation

At each index:
choose include or exclude.
Use recursion to explore all possibilities.
Backtrack after each choice.
*/
