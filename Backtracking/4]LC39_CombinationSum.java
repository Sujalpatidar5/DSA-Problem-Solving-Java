/*
Problem: 39. Combination Sum

-----------------------------------------------------

Problem Statement

Given an array of distinct integers nums and a target,
return all unique combinations where the chosen numbers sum to target.

You can use the same number multiple times.

-----------------------------------------------------

Pattern Used & Why

Pattern: Backtracking (Pick / Not Pick)

Why:
- At every index → 2 choices:
  1. Pick element (can reuse it)
  2. Skip element

-----------------------------------------------------

Key Idea

- If we pick → stay at same index (reuse allowed)
- If we skip → move to next index
- Stop when target becomes 0

-----------------------------------------------------

Algorithm / Process

1. Start from index 0
2. If target == 0 → add combination
3. If index out of bounds OR target < 0 → stop
4. Include current element → stay at same index
5. Backtrack (remove element)
6. Exclude → move to next index

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        solve(nums, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void solve(int[] nums, int target, int i,
                       List<Integer> curr, List<List<Integer>> res) {

        // base case
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i == nums.length || target < 0) return;

        // include (reuse same index)
        curr.add(nums[i]);
        solve(nums, target - nums[i], i, curr, res);

        // backtrack
        curr.remove(curr.size() - 1);

        // exclude (move to next index)
        solve(nums, target, i + 1, curr, res);
    }
}

/*
-----------------------------------------------------

Time Complexity
O(2^n * target)  (approx)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
nums = [2,3,6,7], target = 7

Output:
[[2,2,3],[7]]

-----------------------------------------------------

 Explanation

Use backtracking.
Pick element (reuse allowed) or skip it.
Add combination when target becomes 0.
*/
