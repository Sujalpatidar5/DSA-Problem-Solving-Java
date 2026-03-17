/*
Problem: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/

-----------------------------------------------------

Problem Statement

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up
to the target.

You may assume that each input has exactly one solution,
and you may not use the same element twice.

Return the answer in any order.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap (Value → Index)

Why:
While traversing the array, we store elements in a HashMap.
For each element we check whether its required complement
(target - current) already exists in the map.

This allows us to solve the problem in O(n) time.

-----------------------------------------------------

Key Idea

For each element:

curr = nums[i]

required = target - curr

Check:
If required already exists in the map → we found the pair.

Otherwise store the current number and its index.

-----------------------------------------------------

Algorithm / Process

1. Create a HashMap<Integer, Integer>.
2. Traverse the array.
3. For each element:
      curr = nums[i]
      required = target - curr
4. If required exists in the map:
      return indices.
5. Otherwise store curr → index in the map.
6. Continue traversal.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans[] = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int curr = nums[i];
            int required = target - curr;

            if (map.containsKey(required)) {

                ans[0] = i;
                ans[1] = map.get(required);

                return ans;
            }

            map.put(curr, i);
        }

        return ans;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

Each element is processed once.

-----------------------------------------------------

Space Complexity
O(n)

For storing elements in the HashMap.

-----------------------------------------------------

Example

Input:
nums = [2,7,11,15]
target = 9

Output:
[0,1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9

-----------------------------------------------------

Explanation :

Traverse the array once while storing numbers and their indices
in a HashMap. For every element check if its complement
(target - current) already exists in the map. If yes, return
the indices immediately.
*/
